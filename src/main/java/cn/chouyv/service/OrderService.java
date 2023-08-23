package cn.chouyv.service;

import cn.chouyv.domain.Order;
import cn.chouyv.vo.pay.AcceptOrderVO;
import cn.chouyv.vo.pay.OrderInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SurKaa
 * @description 针对表【order(订单表)】的数据库操作Service
 * @createDate 2023-08-08 15:42:54
 */
public interface OrderService extends IService<Order> {
    OrderInfoVO orderInfo(long id, HttpServletRequest request);

    void acceptOrder(AcceptOrderVO acceptOrderVO, HttpServletRequest request);
}
