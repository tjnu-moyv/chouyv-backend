package cn.chouyv.mapper;

import cn.chouyv.domain.OrderShopProductsItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author SurKaa
 * @description 针对表【order_shop_products_item(订单商品表)】的数据库操作Mapper
 * @createDate 2023-08-08 15:42:54
 * @Entity cn.chouyv.domain.OrderShopProductsItem
 */
@Mapper
public interface OrderShopProductsItemMapper extends BaseMapper<OrderShopProductsItem> {
    public List<OrderShopProductsItem> getOrderShopProductsItem(long id);
}




