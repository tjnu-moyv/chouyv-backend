package cn.chouyv.dto.pay;

import lombok.Data;

import java.io.Serializable;

/**
 * 支付订饭订单请求体
 *
 * @author SurKaa
 */
@Data
public class PayOrderDTO implements Serializable {

    private static final long serialVersionUID = -3460844719626046214L;

    private final Long orderId;
    private final String password;

}
