package cn.chouyv.controller;

import cn.chouyv.domain.Order;
import cn.chouyv.domain.Shop;
import cn.chouyv.service.OrderService;
import cn.chouyv.service.ShopService;
import cn.chouyv.utils.Result;
import cn.chouyv.vo.BaseVO;
import cn.chouyv.vo.run.OrderListVO;
import cn.chouyv.vo.shop.ShopListInfoVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SurKaa
 */
@Slf4j
@RestController
@RequestMapping("/run")
public class RunController {

    private final OrderService orderService;
    private final ShopService shopService;

    public RunController(OrderService orderService, ShopService shopService) {
        this.orderService = orderService;
        this.shopService = shopService;
    }

    /**
     * 获取所有可以接的订单
     *
     * @param pageNum  页面num
     * @param pageSize 页面大小
     * @param request  请求
     * @return {@link BaseVO}<{@link List}<{@link OrderListVO}>>
     */
    @GetMapping("/list")
    public BaseVO<OrderListVO> retrieveAllAvailableOrders(
            @RequestParam(required = false, defaultValue = "1") int pageNum,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            HttpServletRequest request
    ) {
        log.info("retrieveAllAvailableOrders: pageNum={}, pageSize={}", pageNum, pageSize);
        // 查询订单
        IPage<Order> page = orderService.orderListByStatus(Order.STATUS_PAID, pageNum, pageSize, request);
        List<OrderListVO.OrderListItem> items = new ArrayList<>();
        // 订单对应商铺
        page.getRecords().forEach(order -> {
            Shop shopById = shopService.getById(order.getShopId());
            items.add(new OrderListVO.OrderListItem(
                    order,
                    ShopListInfoVO.byShop(shopById)
            ));
        });
        // 整合
        OrderListVO res = new OrderListVO(
                items,
                page.getCurrent(),
                page.getSize(),
                page.getTotal()
        );
        return Result.success(res);
    }
}
