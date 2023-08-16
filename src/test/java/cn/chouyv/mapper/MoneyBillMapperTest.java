package cn.chouyv.mapper;

import cn.chouyv.utils.SnowflakeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MoneyBillMapperTest {

    @Autowired
    private MoneyBillMapper mapper;
    @Autowired
    private SnowflakeUtils snowflake;

    @Test
    void transfer() {
        System.out.println("mapper.transfer(snowflake.newId(), 353, 0, 0, 10) = "
                + mapper.transfer(
                snowflake.newId(),
                353,
                0,
                0,
                10));
    }

    @Test
    void transferToPublicAccount() {
        System.out.println("mapper.transferToPublicAccount(snowflake.newId(), 353, 0, 10) = "
                + mapper.transferToPublicAccount(
                snowflake.newId(),
                353,
                0,
                10
        ));
    }

    @Test
    void transferFromPublicAccount() {
        System.out.println("mapper.transferFromPublicAccount(snowflake.newId(), 353, 0, 20) = "
                + mapper.transferFromPublicAccount(
                snowflake.newId(),
                353,
                0,
                20
        ));
    }
}