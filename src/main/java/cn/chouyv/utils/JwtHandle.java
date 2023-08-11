package cn.chouyv.utils;

import cn.chouyv.exception.TokenException;
import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

import static cn.hutool.jwt.RegisteredPayload.*;

/**
 * Jwt生成token以及鉴权
 *
 * @author SurKaa
 */
@Component
public class JwtHandle {

    // 读取密钥
    @Value("${cn.chouyv.jwt.secrets-key}")
    private String secretKey;

    // 默认过期时间(单位 秒)
    private static final int EXPIRATION_MINUTE = 120 * 60;

    /**
     * 生成JWT token
     *
     * @param id       用户主键
     * @param username 用户名
     * @return token
     */
    public String generateToken(long id, String username) {
        return this.generateToken(id, username, EXPIRATION_MINUTE);
    }

    /**
     * 生成JWT token
     *
     * @param id       用户主键
     * @param username 用户名
     * @param second   过期秒数
     * @return token
     */
    public String generateToken(long id, String username, int second) {
        return new JWT()
                .setIssuer(String.valueOf(id))
                .setSubject(username)
                .setExpiresAt(DateUtil.offsetSecond(new Date(), second))
                .setKey(secretKey.getBytes())
                .sign();
    }

    /**
     * 验证token的合法性 包括检验了过期时间
     *
     * @param token token
     * @return JWT token
     * @throws TokenException jwt不合法 过期 或者异常
     */
    public JWT validate(String token) throws TokenException {
        JWT jwt = JWT.of(token);
        if (jwt.setKey(secretKey.getBytes()).validate(5)) {
            return jwt;
        }
        throw TokenException.error("非法token或者过期token");
    }

}
