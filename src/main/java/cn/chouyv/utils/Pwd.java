package cn.chouyv.utils;

import org.springframework.util.DigestUtils;

/**
 * 获取密文
 *
 * @author SurKaa
 */
public class Pwd {

    /**
     * 获取加密后的密码
     *
     * @param password 密码明文
     * @return 密码密文
     */
    public static String md5DigestAsHex(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
