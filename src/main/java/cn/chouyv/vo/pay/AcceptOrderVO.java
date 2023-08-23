package cn.chouyv.vo.pay;

import lombok.Data;

/**
 * 确认收货
 *
 * @author SurKaa
 */
@Data
public class AcceptOrderVO {

    private long orderId;
    private String password;

}
