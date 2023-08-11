package cn.chouyv.service;

import cn.chouyv.common.response.ShopListInfoResponse;
import cn.chouyv.common.response.ShopListResponse;
import cn.chouyv.common.response.ShoppingInfoResponse;
import cn.chouyv.domain.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author SurKaa
 * @description 针对表【shop(商家表)】的数据库操作Service
 * @createDate 2023-08-08 15:42:54
 */
public interface ShopService extends IService<Shop> {

    Shop getShopInfoByid(long id);

    ShopListResponse getAllShopsInfo();
}
