package cn.chouyv.controller;

import cn.chouyv.dto.pay.PayOrderDTO;
import cn.chouyv.exception.MoneyException;
import cn.chouyv.service.MoneyService;
import cn.chouyv.utils.Result;
import cn.chouyv.vo.BaseVO;
import cn.chouyv.vo.pay.PayOrderBillInfoVO;
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
     * @return {@link BaseVO}<{@link Long}>
     */
    @PostMapping
    public BaseVO<Long> selfBalance(
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
     * @return {@link BaseVO}<{@link PayOrderBillInfoVO}>
     */
    @PostMapping("/pay")
    public BaseVO<PayOrderBillInfoVO> pay(
            @RequestBody PayOrderDTO orderRequest,
            HttpServletRequest request
    ) {
        return Result.success(
                moneyService.payOrder(orderRequest, request)
        );
    }

}
