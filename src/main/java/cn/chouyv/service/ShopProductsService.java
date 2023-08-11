package cn.chouyv.service;

import cn.chouyv.domain.ShopProducts;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author SurKaa
* @description 针对表【shop_products(商品信息表)】的数据库操作Service
* @createDate 2023-08-08 15:42:54
*/
public interface ShopProductsService extends IService<ShopProducts> {
    List<ShopProducts> getShopProductsById(long id);
}
