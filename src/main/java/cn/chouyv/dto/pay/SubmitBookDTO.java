package cn.chouyv.dto.pay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/15/10:18
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitBookDTO {
    private short type;
    private long shopId;
    public List<SubmitBookItem> products;

    /**
     * 提交订单，未封装
     * Created with IntelliJ IDEA.
     *
     * @author 17986
     * @Author: wang
     * @Date: 2023/08/15/10:21
     * @Description:
     * @date 2023/08/15
     */
    @Data
    public static class SubmitBookItem {
        private long id;
        public long price;
        public long count;
        private String description;
    }
}
