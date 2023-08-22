package cn.chouyv.service;

import cn.chouyv.domain.Shop;
import cn.chouyv.dto.ShopLoginRequest;
import cn.chouyv.dto.ShopRegisterRequest;
import cn.chouyv.dto.SubmitBookRequest;
import cn.chouyv.vo.AuthResponse;
import cn.chouyv.vo.shop.ShopListResponse;
import cn.chouyv.vo.shop.SubmitBookResponse;
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

//    ShopInfoResponse infoShop(HttpServletRequest request);

    SubmitBookResponse produceBook(SubmitBookRequest submitBookRequest, HttpServletRequest request);
}
