package cn.chouyv.controller;

import cn.chouyv.domain.ShoppingInfo;
import cn.chouyv.service.ShoppingInfoService;
import cn.chouyv.utils.Result;
import cn.chouyv.vo.BaseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 管理收货地址的接口
 *
 * @author SurKaa
 */
@Slf4j
@RestController
@RequestMapping("/shopinfo")
public class ShopInfoController {

    private final ShoppingInfoService shoppingInfoService;

    public ShopInfoController(ShoppingInfoService shoppingInfoService) {
        this.shoppingInfoService = shoppingInfoService;
    }

    /**
     * 增加学生收货地址
     *
     * @param shopInfoDTO 添加基本信息dto
     * @param request     请求
     * @return {@link BaseVO}<{@link Long}>
     */
    @PostMapping
    public BaseVO<Long> addStudentShopInfo(
            @RequestBody ShoppingInfo shopInfoDTO,
            HttpServletRequest request
    ) {
        log.info("addStudentShopInfo: studentShopInfoDTO={}", shopInfoDTO);
        long id = shoppingInfoService.addStudentShopInfo(shopInfoDTO, request);
        return Result.success(id);
    }

    /**
     * 更新学生收货地址
     *
     * @param shoppingInfoDTO 更新学生基本信息dto
     * @param request         请求
     * @return {@link BaseVO}<?>
     */
    @PutMapping
    public BaseVO<?> updateStudentShopInfo(
            @RequestBody ShoppingInfo shoppingInfoDTO,
            HttpServletRequest request
    ) {
        log.info("updateStudentShopInfo: shoppingInfoDTO={}", shoppingInfoDTO);
        shoppingInfoService.updateStudentShopInfo(shoppingInfoDTO, request);
        return Result.success();
    }

    /**
     * 删除学生收货地址
     *
     * @param shopInfo id
     * @return {@link BaseVO}<?>
     */
    @DeleteMapping
    public BaseVO<?> deleteStudentShopInfo(
            @RequestBody ShoppingInfo shopInfo,
            HttpServletRequest request
    ) {
        log.info("deleteStudentShopInfo: id={}", shopInfo.getId());
        shoppingInfoService.deleteStudentShopInfo(shopInfo.getId(), request);
        return Result.success();
    }

    @GetMapping
    public BaseVO<List<ShoppingInfo>> getStudentShopInfo(HttpServletRequest request) {
        log.info("getStudentShopInfo: request={}", request);
        return Result.success(
                shoppingInfoService.getStudentShopInfo(request)
        );
    }
}
