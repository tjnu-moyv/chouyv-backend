package cn.chouyv.vo.pay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 提交订单响应
 * Created with IntelliJ IDEA.
 *
 * @author 17986
 * @Author: wang
 * @Date: 2023/08/15/10:00
 * @Description:
 * @date 2023/08/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitBookVO {
    private long orderId;
    private long totalPrice;
}
