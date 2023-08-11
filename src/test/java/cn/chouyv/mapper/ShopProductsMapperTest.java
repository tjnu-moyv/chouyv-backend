package cn.chouyv.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/10/14:29
 * @Description:
 */
@SpringBootTest
public class ShopProductsMapperTest {
    @Autowired
    private ShopProductsMapper shopProductsMapper;

    @Test
    public void selectAllByShopIdListTest(){
        System.out.println("shopProductsMapper.selectAllByShopIdList(414L) = " + shopProductsMapper.selectAllByShopIdList(414L));
    }
}
