package cn.chouyv.vo.pay;

import cn.chouyv.domain.Order;
import cn.chouyv.domain.OrderShopProductsItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询订单信息返回体
 *
 * @Author: wang
 * @Date: 2023/08/14/15:03
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoResponse {
    private Order order;
    private List<OrderShopProductsItem> orderShopProductsItems;


}
