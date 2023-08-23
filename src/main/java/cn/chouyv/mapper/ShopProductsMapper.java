package cn.chouyv.mapper;

import cn.chouyv.domain.ShopProducts;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author SurKaa
 * @description 针对表【shop_products(商品信息表)】的数据库操作Mapper
 * @createDate 2023-08-08 15:42:54
 * @Entity cn.chouyv.domain.ShopProducts
 */
@Mapper
public interface ShopProductsMapper extends BaseMapper<ShopProducts> {

    /**
     * 根据商店id查询商店所有信息
     *
     * @param shopId 商店id
     * @return {@link List}<{@link ShopProducts}>
     */
    default List<ShopProducts> selectAllByShopIdList(long shopId) {
        LambdaQueryWrapper<ShopProducts> lqw = new LambdaQueryWrapper<>();
        lqw.eq(ShopProducts::getShopId, shopId);
        return this.selectList(lqw);
    }

}




