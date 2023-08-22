package cn.chouyv.service.impl;

import cn.chouyv.domain.Shop;
import cn.chouyv.domain.Student;
import cn.chouyv.dto.pay.SubmitBookDTO;
import cn.chouyv.dto.shop.ShopLoginDTO;
import cn.chouyv.dto.shop.ShopRegisterDTO;
import cn.chouyv.exception.LoginException;
import cn.chouyv.exception.ProductCountError;
import cn.chouyv.exception.RegisterException;
import cn.chouyv.exception.TokenException;
import cn.chouyv.mapper.ShopMapper;
import cn.chouyv.mapper.StudentMapper;
import cn.chouyv.service.ShopService;
import cn.chouyv.utils.JwtHandle;
import cn.chouyv.utils.SnowflakeUtils;
import cn.chouyv.vo.AuthVO;
import cn.chouyv.vo.pay.SubmitBookVO;
import cn.chouyv.vo.shop.ShopListVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

import static cn.chouyv.utils.Pwd.md5DigestAsHex;

/**
 * @author SurKaa
 * @description 针对表【shop(商家表)】的数据库操作Service实现
 * @createDate 2023-08-08 15:42:54
 */
@Slf4j
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop>
        implements ShopService {

    private final JwtHandle jwtHandle;
    private final SnowflakeUtils snowflake;
    private final StudentMapper studentMapper;

    public ShopServiceImpl(
            JwtHandle jwtHandle,
            SnowflakeUtils snowflake,
            StudentMapper studentMapper
    ) {
        this.jwtHandle = jwtHandle;
        this.snowflake = snowflake;
        this.studentMapper = studentMapper;
    }

    @Override
    public ShopListVO getAllShopsInfo(HttpServletRequest request) {


        String username;
        try {
            username = (String) request.getAttribute("username");
        } catch (ClassCastException e) {
            throw TokenException.error("token异常");
        }
        if (username == null) {
            throw TokenException.error("token异常");
        }

        // 不允许未登录的查看
        Shop shop = getBaseMapper().selectOneByUsername(username);
        Student student = studentMapper.selectOneByUsername(username);
        if (null == shop && null == student) {
            throw TokenException.error("请使用用户账号查看");
        }

        List<Shop> shops = getBaseMapper().selectList(null);

        return new ShopListVO(ShopListVO.shopListInfo(shops));
    }

    /**
     * 商家注册
     *
     * @param registerRequest 注册请求返回体
     * @return 登录成功后返回的认证响应
     */
    @Override
    public AuthVO registerShop(ShopRegisterDTO registerRequest) {
        if (null == registerRequest) {
            throw RegisterException.error("请求体为空");
        }

        String username = registerRequest.getUsername();
        String password = registerRequest.getPassword();
        String checkPwd = registerRequest.getCheckPwd();

        if (null == username || username.length() < 6) {
            throw RegisterException.error("账号长度不能小于6位");
        }

        log.debug("注册用户名: username={}", username);

        if (null == password || password.length() < 6) {
            throw RegisterException.error("密码长度不能小于6位");
        }

        if (null == checkPwd || checkPwd.length() < 6) {
            throw RegisterException.error("确认密码长度不能小于6位");
        }

        if (!password.equals(checkPwd)) {
            throw RegisterException.error("两次密码不一致");
        }

        if (checkCharInAuthString(username)) {
            throw RegisterException.error("账号不能包含特殊字符");
        }

        if (checkCharInAuthString(password)) {
            throw RegisterException.error("密码不能包含特殊字符");
        }

        Shop byUsername = getBaseMapper().selectOneByUsername(username);

        if (null != byUsername) {
            throw RegisterException.error("账号已存在");
        }

        String pwd = md5DigestAsHex(password);
        long id = snowflake.newId();
        Shop shop = new Shop(id, username, pwd);
        log.debug("即将保存商铺信息: {}", shop);
        boolean flag = this.save(shop);
        if (!flag) {
            // 注册失败
            throw RegisterException.error("注册失败");
        }
        String token = jwtHandle.generateToken(id, username);
        log.debug("注册成功 token: {}", token);
        return new AuthVO(id, username, token);
    }

    /**
     * 商家登录
     *
     * @param loginRequest 登录请求体
     * @return 登录成功后返回的认证响应
     */
    @Override
    public AuthVO loginShop(ShopLoginDTO loginRequest) {
        if (null == loginRequest) {
            throw LoginException.error("请求体为空");
        }

        String username = loginRequest.getUsername();
        String inputPwd = loginRequest.getPassword();

        if (null == username || username.length() < 6) {
            throw LoginException.error("账号长度不能小于6位");
        }

        log.debug("登录用户名: username={}", username);

        if (null == inputPwd || inputPwd.length() < 6) {
            throw LoginException.error("密码长度不能小于6位");
        }

        if (checkCharInAuthString(username)) {
            throw LoginException.error("账号不能包含特殊字符");
        }

        if (checkCharInAuthString(inputPwd)) {
            throw LoginException.error("密码不能包含特殊字符");
        }

        log.debug("开始检查是否存在该用户");
        Shop byUsername = getBaseMapper().selectOneByUsername(username);

        if (null == byUsername) {
            throw LoginException.error("没有找到这个商家");
        }

        String input = md5DigestAsHex(inputPwd);
        if (!Objects.equals(input, byUsername.getPassword())) {
            throw LoginException.error("用户名或密码错误");
        }

        Shop safe = Shop.safe(byUsername);
        String token = jwtHandle.generateToken(
                safe.getId(), safe.getUsername());
        log.debug("登录成功 token: {}", token);
        return new AuthVO(safe.getId(), safe.getUsername(), token);
    }

    private static boolean checkCharInAuthString(String authString) {
        // 分别包括:
        // a-z, A-Z
        // 0-9
        return !authString.matches("^[a-zA-Z0-9!-.:-@]+$");
    }

    @Override
    public SubmitBookVO produceBook(SubmitBookDTO submitBookDTO, HttpServletRequest request) {
        long tokenId = Long.parseLong((String) request.getAttribute("id"));

        long l = snowflake.newId();
        long sumMoney = 0;
        for (int i = 0; i < submitBookDTO.products.size(); i++) {
            if (submitBookDTO.products.get(i).count < 0) {
                throw ProductCountError.error("数量不能为负");
            } else if (submitBookDTO.products.get(i).price < 0) {
                throw ProductCountError.error("金额不能为负");
            }

            sumMoney += submitBookDTO.products.get(i).count * submitBookDTO.products.get(i).price;
        }

        this.getBaseMapper().produceBook(l, tokenId, sumMoney, submitBookDTO.getShopId(), submitBookDTO.getType());
        return new SubmitBookVO(l, sumMoney);
    }

}





