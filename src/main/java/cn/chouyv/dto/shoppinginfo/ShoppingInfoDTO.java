package cn.chouyv.dto.shoppinginfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于添加或者更新收货地址的DTO
 *
 * @author SurKaa
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingInfoDTO {

    private long id;
    private String name;
    private String phone;
    private String location;

}
