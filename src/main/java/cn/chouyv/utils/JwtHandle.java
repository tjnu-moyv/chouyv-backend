package cn.chouyv.utils;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
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

    // 过期时间(两个小时)
    private static final long EXPIRATION_TIME = 3600_000L;


    /**
     * 生成JWT token
     *
     * @param id       用户主键
     * @param username 用户名
     * @param hours    过期小时数
     * @return token
     */
    public String generateToken(long id, String username, int hours) {
        Map<String, Object> payload = new HashMap<>();
        long exp = System.currentTimeMillis() + EXPIRATION_TIME * hours;
        payload.put(ISSUER, id);
        payload.put(SUBJECT, username);
        payload.put(EXPIRES_AT, exp);
        return JWTUtil.createToken(payload, secretKey.getBytes());
    }

    /**
     * 验证token的合法性
     *
     * @param token token
     * @return 是否合法
     */
    public boolean validate(String token) {
        return this.validate(token, null, null);
    }

    /**
     * 验证token的合法性
     *
     * @param token    token
     * @param id       id
     * @param username username
     * @return 是否合法
     */
    public boolean validate(String token, Long id, String username) {
        if (!JWTUtil.verify(token, secretKey.getBytes())) {
            return false;
        }
        // 解析 token
        final JWT jwt = JWTUtil.parseToken(token);

        // 检验id
        String idStr = (String) jwt.getPayload(ISSUER);
        Long idLong = Long.parseLong(idStr);
        if (id != null && !Objects.equals(idLong, id)) {
            return false;
        }

        // 检验用户名
        if (username != null) {
            String usernameStr = (String) jwt.getPayload(SUBJECT);
            if (usernameStr.length() > 0
                    && Objects.equals(usernameStr, username)) {
                return false;
            }
        }

        // 检验过期时间
        return jwt.validate(5);
    }


}
