package cn.chouyv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.chouyv.domain.Order;
import cn.chouyv.service.OrderService;
import cn.chouyv.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author SurKaa
* @description 针对表【order(订单表)】的数据库操作Service实现
* @createDate 2023-08-08 15:42:54
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




