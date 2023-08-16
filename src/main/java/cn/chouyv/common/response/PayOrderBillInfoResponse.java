package cn.chouyv.common.response;

import lombok.Data;

/**
 * 支付成功后的账单返回体
 *
 * @author SurKaa
 */
@Data
public class PayOrderBillInfoResponse {
    /**
     * 余额
     */
    private long balance;
    /**
     * 账单
     */
    private BillInfo bill;


    /**
     * 账单
     * <p>
     * 账单返回体
     */
    @Data
    public static class BillInfo {
        private String createdAt;
        private long fromId;
        private long id;
        private long money;
        private long toId;
        private long type;
    }
}
