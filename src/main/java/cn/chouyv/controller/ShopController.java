package cn.chouyv.controller;

import cn.chouyv.common.response.BaseResponse;
import cn.chouyv.common.shop.ShopResponse;
import cn.chouyv.domain.Shop;
import cn.chouyv.service.ShopService;
import cn.chouyv.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/shop")
    public BaseResponse<ShopResponse> getShopInfoById(@RequestParam Integer id) {
        log.info("收到请求 参数id={}", id);
        Shop shopInfoById = shopService.getShopInfoByid(id);
        ShopResponse shopResponse = ShopResponse.toShopResponse(shopInfoById);
        return Result.success(200,shopResponse);
    }
}
