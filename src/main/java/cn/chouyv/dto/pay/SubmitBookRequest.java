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
public class SubmitBookRequest {
    private short type;
    private long shopId;
    public  List<SubmitBook> products;
}
