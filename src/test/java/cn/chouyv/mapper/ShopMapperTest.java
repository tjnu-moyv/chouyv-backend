package cn.chouyv.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShopMapperTest {

    @Autowired
    private ShopMapper shopMapper;

    @Test
    public void selectOneByIdShopTest() {
        System.out.println("shopMapper.selectOneByIdShop(1) = "
                + shopMapper.selectOneByIdShop(1L));
    }

}
