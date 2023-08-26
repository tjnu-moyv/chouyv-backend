package cn.chouyv.vo.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/09/17:54
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopVO {

    private Long id;
    private String nickname;
    private String address;
    private String phone;

}
