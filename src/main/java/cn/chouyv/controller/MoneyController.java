package cn.chouyv.controller;

import cn.chouyv.common.request.PayOrderRequest;
import cn.chouyv.common.response.BaseResponse;
import cn.chouyv.common.response.PayOrderBillInfoResponse;
import cn.chouyv.exception.MoneyException;
import cn.chouyv.service.MoneyService;
import cn.chouyv.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SurKaa
 */
@RestController
@RequestMapping("/money")
public class MoneyController {

    private final MoneyService moneyService;

    public MoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }


    /**
     * 自己的余额
     *
     * @param request 请求
     * @return {@link BaseResponse}<{@link Long}>
     */
    @PostMapping
    public BaseResponse<Long> selfBalance(
            HttpServletRequest request
    ) {
        try {
            long id = Long.parseLong((String) request.getAttribute("id"));
            return Result.success(
                    moneyService.getMoney(id).getCny()
            );
        } catch (NumberFormatException e) {
            throw MoneyException.error("");
        }
    }

    /**
     * 支付订单
     *
     * @param orderRequest 订单请求
     * @param request      请求
     * @return {@link BaseResponse}<{@link PayOrderBillInfoResponse}>
     */
    @PostMapping("/pay")
    public BaseResponse<PayOrderBillInfoResponse> pay(
            @RequestBody PayOrderRequest orderRequest,
            HttpServletRequest request
    ) {
        return Result.success(
                moneyService.payOrder(orderRequest, request)
        );
    }

}
