package cn.chouyv.service;

import cn.chouyv.domain.Money;
import cn.chouyv.dto.pay.PayOrderDTO;
import cn.chouyv.vo.pay.PayOrderBillInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SurKaa
 * @description 针对表【money(用户钱包表)】的数据库操作Service
 * @createDate 2023-08-08 15:42:54
 */
public interface MoneyService extends IService<Money> {

    /**
     * 给用户开户
     *
     * @param uid 开户id
     * @return 开户信息
     */
    Money createMoney(long uid);

    /**
     * 得到余额
     *
     * @param uid uid
     * @return {@link Money}
     */
    Money getMoney(long uid);

    /**
     * 支付订单
     *
     * @param orderRequest 订单请求
     * @param request      请求
     * @return {@link PayOrderBillInfoVO}
     */
    PayOrderBillInfoVO payOrder(
            PayOrderDTO orderRequest,
            HttpServletRequest request
    );

    /**
     * 开户
     *
     * @param request 请求
     * @return {@link Money}
     */
    Money newAccount(HttpServletRequest request);
}
