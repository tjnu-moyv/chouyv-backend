package cn.chouyv.service.impl;

import cn.chouyv.common.request.ShopLoginRequest;
import cn.chouyv.common.request.ShopRegisterRequest;
import cn.chouyv.common.response.*;
import cn.chouyv.domain.Shop;
import cn.chouyv.exception.LoginException;
import cn.chouyv.exception.ShopInfoException;
import cn.chouyv.mapper.ShopMapper;
import cn.chouyv.service.ShopService;
import cn.chouyv.utils.JwtHandle;
import cn.chouyv.utils.SnowflakeUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Objects;


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
    public ShopListResponse getAllShopsInfo(){
        ShopListResponse shopListResponse=ShopListResponse.toShopListResponse(getBaseMapper().getAllShopsInfo());
        return shopListResponse;
    }

    /**
     * 商家注册
     * @param registerRequest 注册请求返回体
     * @return 登录成功后返回的认证响应
     */
    @Override
    public AuthResponse registerShop(ShopRegisterRequest registerRequest) {
        return null;
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
}





