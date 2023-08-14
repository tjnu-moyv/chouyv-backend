package cn.chouyv.service;

import cn.chouyv.domain.OrderShopProductsItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author SurKaa
* @description 针对表【order_shop_products_item(订单商品表)】的数据库操作Service
* @createDate 2023-08-08 15:42:54
*/
public interface OrderShopProductsItemService extends IService<OrderShopProductsItem> {
     public List<OrderShopProductsItem> getOrderShopProductsItem(long id);
}
