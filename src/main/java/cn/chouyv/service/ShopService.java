package cn.chouyv.service;

import cn.chouyv.common.request.SubmitBookRequest;
import cn.chouyv.common.response.shop.ShopListResponse;
import cn.chouyv.common.response.shop.SubmitBookResponse;
import cn.chouyv.domain.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SurKaa
 * @description 针对表【shop(商家表)】的数据库操作Service
 * @createDate 2023-08-08 15:42:54
 */
public interface ShopService extends IService<Shop> {

    Shop getShopInfoById(long id);

    ShopListResponse getAllShopsInfo();
    SubmitBookResponse produceBook(SubmitBookRequest submitBookRequest, HttpServletRequest request);
}
