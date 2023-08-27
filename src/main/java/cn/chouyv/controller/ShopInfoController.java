package cn.chouyv.controller;

import cn.chouyv.domain.ShoppingInfo;
import cn.chouyv.dto.shoppinginfo.ShoppingInfoDTO;
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
            @RequestBody ShoppingInfoDTO shopInfoDTO,
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
    public BaseVO<Boolean> updateStudentShopInfo(
            @RequestBody ShoppingInfoDTO shoppingInfoDTO,
            HttpServletRequest request
    ) {
        log.info("updateStudentShopInfo: shoppingInfoDTO={}", shoppingInfoDTO);
        return Result.success(
                shoppingInfoService.updateStudentShopInfo(shoppingInfoDTO, request)
        );
    }

    /**
     * 删除学生收货地址
     *
     * @param id id
     * @return {@link BaseVO}<?>
     */
    @DeleteMapping("/{id}")
    public BaseVO<Boolean> deleteStudentShopInfo(
            @PathVariable long id,
            HttpServletRequest request
    ) {
        log.info("deleteStudentShopInfo: id={}", id);
        return Result.success(
                shoppingInfoService.deleteStudentShopInfo(id, request)
        );
    }

    @GetMapping
    public BaseVO<List<ShoppingInfo>> getStudentShopInfo(HttpServletRequest request) {
        log.info("getStudentShopInfo: request={}", request);
        return Result.success(
                shoppingInfoService.getStudentShopInfo(request)
        );
    }
}
