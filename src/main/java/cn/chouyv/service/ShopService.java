package cn.chouyv.service;

import cn.chouyv.domain.Shop;
import cn.chouyv.dto.pay.SubmitBookDTO;
import cn.chouyv.dto.shop.ShopLoginDTO;
import cn.chouyv.dto.shop.ShopRegisterDTO;
import cn.chouyv.vo.AuthVO;
import cn.chouyv.vo.pay.SubmitBookVO;
import cn.chouyv.vo.shop.ShopListVO;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 81047
 * @description 针对表【shop(商家表)】的数据库操作Service
 * @createDate 2023-08-08 15:42:54
 */
public interface ShopService extends IService<Shop> {

    Shop getShopInfoById(long id);

    ShopListVO getAllShopsInfo();

    /**
     * 商家注册
     *
     * @param registerRequest 注册请求返回体
     * @return 注册返回体
     */

    AuthVO registerShop(ShopRegisterDTO registerRequest);

    /**
     * 商家登录
     *
     * @param loginRequest 登录请求体
     * @return 登录返回体
     */

    AuthVO loginShop(ShopLoginDTO loginRequest);

//    ShopInfoVO infoShop(HttpServletRequest request);

    SubmitBookVO produceBook(SubmitBookDTO submitBookDTO, HttpServletRequest request);
}
