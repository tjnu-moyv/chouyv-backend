package cn.chouyv.controller;

import cn.chouyv.domain.Shop;
import cn.chouyv.domain.ShopProducts;
import cn.chouyv.dto.shop.ShopLoginDTO;
import cn.chouyv.dto.shop.ShopRegisterDTO;
import cn.chouyv.exception.NoFoundException;
import cn.chouyv.service.ShopProductsService;
import cn.chouyv.service.ShopService;
import cn.chouyv.utils.Result;
import cn.chouyv.vo.AuthVO;
import cn.chouyv.vo.BaseVO;
import cn.chouyv.vo.shop.ShopAndProductVO;
import cn.chouyv.vo.shop.ShopListVO;
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
    public BaseVO<ShopListVO> getAllShopsInfo(
            HttpServletRequest request
    ) {
        return Result.success(shopService.getAllShopsInfo(request));
    }

}
