package cn.chouyv.vo;

import cn.chouyv.domain.MoneyBill;
import lombok.AllArgsConstructor;
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

    public PayOrderBillInfoResponse(long balance, MoneyBill mb) {
        this.balance = balance;
        this.bill = new BillInfo(
                mb.getId(),
                mb.getFromId(),
                mb.getToId(),
                mb.getMoney(),
                mb.getType(),
                mb.getCreatedAt().toString()
        );
    }

    /**
     * 账单
     * <p>
     * 账单返回体
     */
    @Data
    @AllArgsConstructor
    private static class BillInfo {
        private long id;
        private long fromId;
        private long toId;
        private long money;
        private long type;
        private String createdAt;
    }
}
