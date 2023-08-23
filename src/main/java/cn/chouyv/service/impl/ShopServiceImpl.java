package cn.chouyv.service.impl;

import cn.chouyv.domain.*;
import cn.chouyv.dto.pay.SubmitBookDTO;
import cn.chouyv.dto.shop.ShopLoginDTO;
import cn.chouyv.dto.shop.ShopRegisterDTO;
import cn.chouyv.exception.*;
import cn.chouyv.mapper.*;
import cn.chouyv.service.ShopService;
import cn.chouyv.utils.JwtHandle;
import cn.chouyv.utils.SnowflakeUtils;
import cn.chouyv.vo.AuthVO;
import cn.chouyv.vo.pay.SubmitBookVO;
import cn.chouyv.vo.shop.ShopListVO;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

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
    private final ShopProductsMapper shopProductsMapper;
    private final OrderShopProductsItemMapper orderShopProductsItemMapper;
    private final OrderMapper orderMapper;

    public ShopServiceImpl(
            JwtHandle jwtHandle,
            OrderMapper orderMapper,
            SnowflakeUtils snowflake,
            StudentMapper studentMapper,
            ShopProductsMapper shopProductsMapper,
            OrderShopProductsItemMapper orderShopProductsItemMapper
    ) {
        this.jwtHandle = jwtHandle;
        this.orderMapper = orderMapper;
        this.snowflake = snowflake;
        this.studentMapper = studentMapper;
        this.shopProductsMapper = shopProductsMapper;
        this.orderShopProductsItemMapper = orderShopProductsItemMapper;
    }

    @Override
    public ShopListVO getAllShopsInfo(HttpServletRequest request) {


        String username;
        try {
            username = (String) request.getAttribute("username");
        } catch (ClassCastException e) {
            throw TokenException.errorToken();
        }
        if (username == null) {
            throw TokenException.errorToken();
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
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class) // 遇到错误回滚
    public SubmitBookVO produceBook(SubmitBookDTO submitBookDTO, HttpServletRequest request) {
        long tokenId = (long) request.getAttribute("id");
        String username = (String) request.getAttribute("username");
        Student student = studentMapper.selectOneByIdAndUsernameStudent(tokenId, username);
        if (student == null) {
            throw TokenException.errorToken();
        }
        // 登陆了
        log.info("Student: {}", student);

        // 检测type
        int type = submitBookDTO.getType();
        // TODO 日后新增type需要更改这里 麻烦
        if (type != Order.TYPE_DINE_IN && type != Order.TYPE_TAKE_AWAY && type != Order.TYPE_FIND_RUNNER) {
            throw MoneyException.error("非法type");
        }

        // 生成id
        long orderId = snowflake.newId();
        // 总价
        AtomicInteger sumPrice = new AtomicInteger(0);

        // 遍历获取, 而不是一下子找全部 同时也能减少内存负担, (TODO 其次还允许用户跨商铺购买)
        submitBookDTO.getProducts().forEach(submitProduct -> {
            if (submitProduct.getCount() <= 0) {
                throw ProductCountException.error("购买数量非法");
            }
            // 查找对应的商品
            ShopProducts product = shopProductsMapper.selectById(submitProduct.getId());
            if (product == null) {
                throw MoneyException.error("商品id错误: " + submitProduct.getId());
            }
            // 计算总价
            sumPrice.addAndGet(submitProduct.getCount() * product.getPrice());
            // 保存订单商品item
            int insert = orderShopProductsItemMapper.insert(
                    OrderShopProductsItem.builder()
                            .id(snowflake.newId())
                            .orderId(orderId)
                            .shopProductsId(submitProduct.getId())
                            .count(submitProduct.getCount())
                            .description(submitProduct.getDescription())
                            .build()
            );
            if (insert <= 0) {
                throw MoneyException.error("请重试");
            }
        });

        int insert = orderMapper.insert(
                Order.builder()
                        .id(orderId)
                        .studentId(tokenId)
                        .shopId(submitBookDTO.getShopId())
                        .totalPrice(sumPrice.get())
                        .status(Order.STATUS_WAIT_PAY)
                        .type(type)
                        .targetTime(DateUtil.offsetHour(new Date(), 3)) // TODO 默认三个小时后
                        .build()
        );

        if (insert <= 0) {
            throw MoneyException.error("请重试");
        }

        return new SubmitBookVO(orderId, sumPrice.get());
    }

}





