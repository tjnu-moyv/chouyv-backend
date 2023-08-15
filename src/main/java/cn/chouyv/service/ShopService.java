package cn.chouyv.service;

import cn.chouyv.common.request.ShopLoginRequest;
import cn.chouyv.common.request.ShopRegisterRequest;
import cn.chouyv.common.request.StudentLoginRequest;
import cn.chouyv.common.request.StudentRegisterRequest;
import cn.chouyv.common.response.AuthResponse;
import cn.chouyv.common.response.shop.ShopListResponse;
import cn.chouyv.common.response.shop.StudentInfoResponse;
import cn.chouyv.common.request.SubmitBookRequest;
import cn.chouyv.common.response.shop.ShopListResponse;
import cn.chouyv.common.response.shop.SubmitBookResponse;
import cn.chouyv.domain.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 81047
 * @description 针对表【shop(商家表)】的数据库操作Service
 * @createDate 2023-08-08 15:42:54
 */
public interface ShopService extends IService<Shop> {

    Shop getShopInfoById(long id);

    ShopListResponse getAllShopsInfo();
    /**
     * 商家注册
     *
     * @param registerRequest 注册请求返回体
     * @return 注册返回体
     */

    AuthResponse registerShop(ShopRegisterRequest registerRequest);

    /**
     * 商家登录
     *
     * @param loginRequest 登录请求体
     * @return 登录返回体
     */

    AuthResponse loginShop(ShopLoginRequest loginRequest);

//    ShoplnfoResponse infoShop(HttpServletRequest request);

    SubmitBookResponse produceBook(SubmitBookRequest submitBookRequest, HttpServletRequest request);
}
