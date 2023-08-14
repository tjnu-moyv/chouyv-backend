package cn.chouyv.service.impl;

import cn.chouyv.exception.SelectWithoutPermissionException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.chouyv.domain.Order;
import cn.chouyv.service.OrderService;
import cn.chouyv.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SurKaa
 * @description 针对表【order(订单表)】的数据库操作Service实现
 * @createDate 2023-08-08 15:42:54
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {

    @Override
    public Order getOderInfoById(long id, HttpServletRequest request) {
        String tokenId = (String) request.getAttribute("id");
        try {
            long studentId = Long.parseLong(tokenId);
            Order orderInfoById = this.getBaseMapper().getOrderInfoById(id, studentId);
            if (orderInfoById == null) {
                throw SelectWithoutPermissionException.error("没有找到相应的");
            }
            return orderInfoById;
        } catch (NumberFormatException e) {
            throw SelectWithoutPermissionException.error("Token异常");
        }
    }
}




