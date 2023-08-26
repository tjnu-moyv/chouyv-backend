package cn.chouyv.vo.run;

import cn.chouyv.domain.Order;
import cn.chouyv.vo.shop.ShopListInfoVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author SurKaa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderListVO {

    private List<OrderListItem> list;
    /**
     * 当前页 默认1
     */
    private long current;
    /**
     * 每页显示条数 默认10
     */
    private long size;
    /**
     * 返回记录的总数
     */
    private long total;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderListItem {

        private Order order;
        private ShopListInfoVO shop;

    }

}
