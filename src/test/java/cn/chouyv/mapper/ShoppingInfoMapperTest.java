package cn.chouyv.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShoppingInfoMapperTest {

    @Autowired
    private ShoppingInfoMapper shoppingInfoMapper;

    @Test
    void selectAllByUid() {
        System.out.println("shoppingInfoMapper.selectAllByUid(2) = " + shoppingInfoMapper.selectAllByUid(2));
    }
}