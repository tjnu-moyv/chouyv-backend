package cn.chouyv.common.request;

import cn.chouyv.common.response.shop.SubmitBook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

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
