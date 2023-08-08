package cn.chouyv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.chouyv.domain.OrderShopProductsItem;
import cn.chouyv.service.OrderShopProductsItemService;
import cn.chouyv.mapper.OrderShopProductsItemMapper;
import org.springframework.stereotype.Service;

/**
* @author SurKaa
* @description 针对表【order_shop_products_item(订单商品表)】的数据库操作Service实现
* @createDate 2023-08-08 15:42:54
*/
@Service
public class OrderShopProductsItemServiceImpl extends ServiceImpl<OrderShopProductsItemMapper, OrderShopProductsItem>
    implements OrderShopProductsItemService{

}




