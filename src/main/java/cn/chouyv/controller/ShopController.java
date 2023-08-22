package cn.chouyv.controller;

import cn.chouyv.domain.Order;
import cn.chouyv.domain.OrderShopProductsItem;
import cn.chouyv.domain.Shop;
import cn.chouyv.dto.shop.ShopLoginDTO;
import cn.chouyv.dto.shop.ShopRegisterDTO;
import cn.chouyv.service.OrderService;
import cn.chouyv.service.OrderShopProductsItemService;
import cn.chouyv.service.ShopProductsService;
import cn.chouyv.service.ShopService;
import cn.chouyv.utils.Result;
import cn.chouyv.vo.AuthVO;
import cn.chouyv.vo.BaseVO;
import cn.chouyv.vo.pay.OrderInfoVO;
import cn.chouyv.vo.shop.ShopAndProductVO;
import cn.chouyv.vo.shop.ShopListVO;
import cn.chouyv.vo.shop.ShopVO;
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
    private final OrderService orderService;
    private final OrderShopProductsItemService orderShopProductsItemService;

    @PostMapping("/login")
    public BaseVO<AuthVO> login(
            @RequestBody ShopLoginDTO loginRequest
    ) {
        log.info("Login: {}", loginRequest);
        AuthVO response = shopService.loginShop(loginRequest);
        return Result.success(response);
    }

    @PostMapping("/register")
    public BaseVO<AuthVO> register(
            @RequestBody ShopRegisterDTO registerRequest
    ) {
        log.info("Register: {}", registerRequest);
        AuthVO response = shopService.registerShop(registerRequest);
        return Result.success(response);
    }

    public ShopController(ShopService shopService, ShopProductsService shopProductsService, OrderService orderService, OrderShopProductsItemService orderShopProductsItemService) {
        this.shopService = shopService;
        this.shopProductsService = shopProductsService;
        this.orderService = orderService;
        this.orderShopProductsItemService = orderShopProductsItemService;
    }


//    @GetMapping
//    public BaseVO<ShopVO> getShopInfoById(@RequestParam Integer id) {
//        log.info("收到请求 参数id={}", id);
//        Shop shopInfoById = shopService.getShopInfoByid(id);
//        ShopVO shopResponse = ShopVO.toShopResponse(shopInfoById);
//        return Result.success(200, shopResponse);
//    }

    @GetMapping
    public BaseVO<ShopAndProductVO> getShopAndProductResponse(@RequestParam long id) {
        Shop shopInfoById = shopService.getShopInfoById(id);
        ShopVO shopVO = ShopVO.toShopResponse(shopInfoById);
        ShopAndProductVO shopAndProductVO = new ShopAndProductVO(shopVO, shopProductsService.getShopProductsById(id));
        return Result.success(shopAndProductVO);
    }

    @PostMapping
    public BaseVO<ShopListVO> getAllShopsInfo(
    ) {

        ShopListVO shopListVO = shopService.getAllShopsInfo();
        return Result.success(shopListVO);
    }


    @GetMapping("/order")
    public BaseVO<OrderInfoVO> order(
            @RequestParam long id,
            HttpServletRequest request
    ) {
        Order orderInfoById = orderService.getOderInfoById(id, request);
        List<OrderShopProductsItem> orderShopProductsItemInfoById = orderShopProductsItemService.getOrderShopProductsItem(id);
        OrderInfoVO orderInfoVO = new OrderInfoVO(orderInfoById, orderShopProductsItemInfoById);
        return Result.success(orderInfoVO);
    }




}
