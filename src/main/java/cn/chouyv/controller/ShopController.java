package cn.chouyv.controller;

import cn.chouyv.common.request.ShopLoginRequest;
import cn.chouyv.common.request.ShopRegisterRequest;
import cn.chouyv.common.response.AuthResponse;
import cn.chouyv.common.response.BaseResponse;
import cn.chouyv.common.response.OrderInfoResponse;
import cn.chouyv.common.response.shop.ShopListResponse;
import cn.chouyv.common.response.shop.ShopAndProductResponse;
import cn.chouyv.common.response.shop.ShopResponse;
import cn.chouyv.domain.Order;
import cn.chouyv.domain.OrderShopProductsItem;
import cn.chouyv.domain.Shop;
import cn.chouyv.service.OrderService;
import cn.chouyv.service.OrderShopProductsItemService;
import cn.chouyv.domain.ShopProducts;
import cn.chouyv.exception.NoFoundException;
import cn.chouyv.service.ShopProductsService;
import cn.chouyv.service.ShopService;
import cn.chouyv.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/09/16:16
 * @Description:
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;
    private final ShopProductsService shopProductsService;

    @PostMapping("/login")
    public BaseResponse<AuthResponse> login(
            @RequestBody ShopLoginRequest loginRequest
    ) {
        log.info("Login: {}", loginRequest);
        AuthResponse response = shopService.loginShop(loginRequest);
        return Result.success(response);
    }

    @PostMapping("/register")
    public BaseResponse<AuthResponse> register(
            @RequestBody ShopRegisterRequest registerRequest
    ) {
        log.info("Register: {}", registerRequest);
        AuthResponse response = shopService.registerShop(registerRequest);
        return Result.success(response);
    }

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

    @GetMapping("/{shopId}")
    public BaseVO<ShopAndProductVO> getShopAndProductResponse(@PathVariable long shopId) {
        Shop shopInfoById = shopService.getById(shopId);
        if (shopInfoById == null) {
            throw NoFoundException.error("无此id对应的商铺");
        }
        List<ShopProducts> productsList = shopProductsService.getShopProductsById(shopId);
        if (productsList == null) {
            throw NoFoundException.error("无此id对应的商铺");
        }
        return Result.success(new ShopAndProductVO(
                ShopAndProductVO.oneShopInfo(shopInfoById),
                ShopAndProductVO.shopProductsInfoList(productsList)
        ));
    }

    @PostMapping
    public BaseResponse<ShopListResponse> getAllShopsInfo(
    ) {

        ShopListResponse shopListResponse = shopService.getAllShopsInfo();
        return Result.success(shopListResponse);
    }


    @GetMapping("/order")
    public BaseResponse<OrderInfoResponse> order(
            @RequestParam long id,
            HttpServletRequest request
    ) {
        Order orderInfoById = orderService.getOderInfoById(id,request);
        List<OrderShopProductsItem> orderShopProductsItemInfoById = orderShopProductsItemService.getOrderShopProductsItem(id);
        OrderInfoResponse orderInfoResponse = new OrderInfoResponse(orderInfoById, orderShopProductsItemInfoById);
        return Result.success(orderInfoResponse);
    }




}
