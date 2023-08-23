package cn.chouyv.service.impl;

import cn.chouyv.domain.Order;
import cn.chouyv.domain.ShopProducts;
import cn.chouyv.domain.Student;
import cn.chouyv.exception.NoFoundException;
import cn.chouyv.mapper.OrderMapper;
import cn.chouyv.mapper.OrderShopProductsItemMapper;
import cn.chouyv.mapper.ShopProductsMapper;
import cn.chouyv.mapper.StudentMapper;
import cn.chouyv.service.OrderService;
import cn.chouyv.vo.pay.OrderInfoVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SurKaa
 * @description 针对表【order(订单表)】的数据库操作Service实现
 * @createDate 2023-08-08 15:42:54
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {

    private final StudentMapper studentMapper;
    private final ShopProductsMapper shopProductsMapper;
    private final OrderShopProductsItemMapper orderShopProductsItemMapper;

    public OrderServiceImpl(
            StudentMapper studentMapper,
            ShopProductsMapper shopProductsMapper,
            OrderShopProductsItemMapper orderShopProductsItemMapper
    ) {
        this.studentMapper = studentMapper;
        this.shopProductsMapper = shopProductsMapper;
        this.orderShopProductsItemMapper = orderShopProductsItemMapper;
    }

    @Override
    public OrderInfoVO orderInfo(long orderId, HttpServletRequest request) {
        Student student = studentMapper.checkLogin(request);

        Order order = getBaseMapper().getOrderInfoById(orderId, student.getId());

        if (order == null) {
            throw NoFoundException.error("没有找到对应的订单");
        }

        List<OrderInfoVO.OrderShopProducts> productsForReturn = new ArrayList<>();

        orderShopProductsItemMapper.selectAllByOrderId(orderId).forEach(product -> {
            ShopProducts shopProducts = shopProductsMapper.selectById(product.getShopProductsId());
            productsForReturn.add(new OrderInfoVO.OrderShopProducts(
                    product.getId(),
                    shopProducts.getPrice(),
                    product.getCount(),
                    product.getDescription()
            ));
        });

        return new OrderInfoVO(order, productsForReturn);
    }
}




