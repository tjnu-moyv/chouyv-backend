package cn.chouyv.common.shop;

import cn.chouyv.domain.Shop;
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
public class ShopResponse {

    private Long id;
    private String nickname;
    private String address;
    private String phone;

    public static ShopResponse toShopResponse(Shop shop) {
        return new ShopResponse(
                shop.getId(),
                shop.getNickname(),
                shop.getAddress(),
                shop.getPhone()
        );
    }

}
