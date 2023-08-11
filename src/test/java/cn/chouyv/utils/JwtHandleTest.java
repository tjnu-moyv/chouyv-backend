package cn.chouyv.utils;

import cn.chouyv.exception.TokenException;
import cn.hutool.jwt.JWT;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class JwtHandleTest {

    @Autowired
    private JwtHandle jwtHandle;

    @Test
    void testHandle() {
        Assertions.assertTrue(testValidate(123L, "123123", 1, 0));
        Assertions.assertFalse(testValidate(123456L, "123", 1, 7));
    }

    /**
     * 测试验证
     *
     * @param id       id
     * @param username 用户名
     * @param second   过期时间秒数
     * @param delay    校验延迟秒数
     * @return boolean 生成的token是否通过校验
     */
    boolean testValidate(long id, String username, int second, int delay) {
        System.out.println("==== testValidate start ====");
        System.out.printf("id = %d, username = %s, second = %d, delay = %d\n", id, username, second, delay);
        String token = jwtHandle.generateToken(id, username, second);
        System.out.println("token = " + token);
        // 延时
        try {
            Thread.sleep(delay * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 校验
        try {
            JWT jwt = jwtHandle.validate(token);
            System.out.println("jwt = " + jwt);
            System.out.println("jwt.getPayload() = " + jwt.getPayload());
            System.out.println("jwt.getHeaders() = " + jwt.getHeaders());
            System.out.println("jwt.getSigner() = " + jwt.getSigner());
        } catch (TokenException e) {
            System.out.println("failed");
            System.out.println("==== testValidate  end  ====");
            return false;
        }
        System.out.println("success");
        System.out.println("==== testValidate  end  ====");
        return true;
    }
}