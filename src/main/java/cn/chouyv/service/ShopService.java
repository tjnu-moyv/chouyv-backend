package cn.chouyv.service;

import cn.chouyv.common.response.ShopListResponse;
import cn.chouyv.domain.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author SurKaa
 * @description 针对表【shop(商家表)】的数据库操作Service
 * @createDate 2023-08-08 15:42:54
 */
public interface ShopService extends IService<Shop> {

    Shop getShopInfoById(long id);

    ShopListResponse getAllShopsInfo();
}
