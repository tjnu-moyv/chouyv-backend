package cn.chouyv.service.impl;

import cn.chouyv.common.request.ShopLoginRequest;
import cn.chouyv.common.request.ShopRegisterRequest;
import cn.chouyv.common.response.*;
import cn.chouyv.domain.Shop;
import cn.chouyv.exception.LoginException;
import cn.chouyv.exception.RegisterException;
import cn.chouyv.exception.ShopInfoException;
import cn.chouyv.mapper.ShopMapper;
import cn.chouyv.service.ShopService;
import cn.chouyv.utils.JwtHandle;
import cn.chouyv.common.request.SubmitBookRequest;
import cn.chouyv.common.response.shop.ShopListResponse;
import cn.chouyv.common.response.shop.SubmitBookResponse;
import cn.chouyv.exception.ProductCountError;
import cn.chouyv.utils.SnowflakeUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

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

    public ShopServiceImpl(
            JwtHandle jwtHandle,
            SnowflakeUtils snowflake
    ){
        this.jwtHandle = jwtHandle;
        this.snowflake = snowflake;
    }

    @Override
    public Shop getShopInfoById(long id) {
        if (getBaseMapper().selectById(id) == null) {
            throw ShopInfoException.error("id错误");
        }
        return getBaseMapper().selectById(id);
    }

    @Override
    public ShopListResponse getAllShopsInfo() {
        ShopListResponse shopListResponse = ShopListResponse.toShopListResponse(getBaseMapper().getAllShopsInfo());
        return shopListResponse;
    }

    /**
     * 商家注册
     * @param registerRequest 注册请求返回体
     * @return 登录成功后返回的认证响应
     */
    @Override
    public AuthResponse registerShop(ShopRegisterRequest registerRequest) {
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
        log.debug("即将保存学生信息: {}", shop);
        boolean flag = this.save(shop);
        if (!flag) {
            // 注册失败
            throw RegisterException.error("注册失败");
        }
        String token = jwtHandle.generateToken(id, username);
        log.debug("注册成功 token: {}", token);
        return new AuthResponse(id, username, token);
    }

    /**
     * 商家登录
     *
     * @param loginRequest 登录请求体
     * @return 登录成功后返回的认证响应
     */
    @Override
    public AuthResponse loginShop(ShopLoginRequest loginRequest) {
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
        return new AuthResponse(safe.getId(), safe.getUsername(), token);
    }

    private static boolean checkCharInAuthString(String authString) {
        // 分别包括:
        // a-z, A-Z
        // 0-9
        return !authString.matches("^[a-zA-Z0-9!-.:-@]+$");
    }

    /**
     * 获取加密后的密码
     *
     * @param password 密码明文
     * @return 密码密文
     */
    private static String md5DigestAsHex(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
//    @Override
//    public ShoplnfoResponse infoShop(HttpServletRequest request) {
//        return null;
//    }

    @Override
    public SubmitBookResponse produceBook(SubmitBookRequest submitBookRequest, HttpServletRequest request) {
        long tokenId = Long.parseLong((String) request.getAttribute("id"));

        long l = snowflake.newId();
        long sumMoney=0;
        for (int i = 0; i < submitBookRequest.products.size(); i++) {
            if(submitBookRequest.products.get(i).count<0){
                throw ProductCountError.error("数量不能为负");
            }else if(submitBookRequest.products.get(i).price<0){
                throw  ProductCountError.error("金额不能为负");
            }

            sumMoney += submitBookRequest.products.get(i).count * submitBookRequest.products.get(i).price;
        }

         this.getBaseMapper().produceBook(l,tokenId, sumMoney, submitBookRequest.getShopId(), submitBookRequest.getType());
        return new SubmitBookResponse(l,sumMoney);
    }

}





