package cn.chouyv.controller;

import cn.chouyv.common.response.BaseResponse;
import cn.chouyv.common.response.ShopListInfoResponse;
import cn.chouyv.common.response.ShopListResponse;
import cn.chouyv.common.response.ShoppingInfoResponse;
import cn.chouyv.common.shop.ShopAndProductResponse;
import cn.chouyv.common.shop.ShopResponse;
import cn.chouyv.domain.Shop;
import cn.chouyv.domain.ShopProducts;
import cn.chouyv.domain.ShoppingInfo;
import cn.chouyv.exception.ShopInfoException;
import cn.chouyv.service.ShopProductsService;
import cn.chouyv.service.ShopService;
import cn.chouyv.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.chouyv.exception.ChouYvError.SUCCESS;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/09/16:16
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    private final ShopProductsService shopProductsService;

    public ShopController(ShopService shopService, ShopProductsService shopProductsService) {
        this.shopService = shopService;
        this.shopProductsService = shopProductsService;
    }


//    @GetMapping
//    public BaseResponse<ShopResponse> getShopInfoById(@RequestParam Integer id) {
//        log.info("收到请求 参数id={}", id);
//        Shop shopInfoById = shopService.getShopInfoByid(id);
//        ShopResponse shopResponse = ShopResponse.toShopResponse(shopInfoById);
//        return Result.success(200, shopResponse);
//    }

    @GetMapping
    public BaseResponse<ShopAndProductResponse> getShopAndProductResponse(@RequestParam long id) {
        Shop shopInfoByid = shopService.getShopInfoByid(id);
        ShopResponse shopResponse = ShopResponse.toShopResponse(shopInfoByid);
        ShopAndProductResponse shopAndProductResponse = ShopAndProductResponse.toShopAndProductResponse(shopResponse, shopProductsService.getShopProductsById(id));
        return Result.success(SUCCESS.getCode(), shopAndProductResponse);
    }

    @PostMapping
    public BaseResponse<ShopListResponse> getAllShopsInfo(){
            ShopListResponse shopListResponse=shopService.getAllShopsInfo();
            return Result.success(SUCCESS.getCode(),shopListResponse);
    }

}
