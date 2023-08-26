package cn.chouyv.service;

import cn.chouyv.domain.Order;
import cn.chouyv.vo.pay.AcceptOrderVO;
import cn.chouyv.vo.pay.OrderInfoVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author SurKaa
 * @description 针对表【order(订单表)】的数据库操作Service
 * @createDate 2023-08-08 15:42:54
 */
public interface OrderService extends IService<Order> {
    OrderInfoVO orderInfo(long id, HttpServletRequest request);

    void acceptOrder(AcceptOrderVO acceptOrderVO, HttpServletRequest request);

    /**
     * 订单列表 状态过滤
     *
     * @param status   状态
     * @param request  请求
     * @param pageNum  页面num
     * @param pageSize 页面大小
     * @return {@link List}<{@link Order}>
     */
    IPage<Order> orderListByStatus(int status, int pageNum, int pageSize, HttpServletRequest request);
}
