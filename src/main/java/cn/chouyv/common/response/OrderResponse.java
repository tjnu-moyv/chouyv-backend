package cn.chouyv.common.response;

import cn.chouyv.domain.Order;
import cn.chouyv.domain.OrderShopProductsItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/14/15:03
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Order order;
    private List<OrderShopProductsItem> orderShopProductsItems;


}
