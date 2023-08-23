package cn.chouyv.vo.pay;

import cn.chouyv.domain.Order;
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
public class OrderInfoVO {
    private Order order;
    private List<OrderShopProducts> orderShopProductsItems;

    /**
     * 单个商品的购物车
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderShopProducts {
        /**
         * 商品主键(shop_products_id)
         */
        private long id;
        /**
         * 单价
         */
        private double price;
        private long count;
        private String description;
    }

}
