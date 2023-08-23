package cn.chouyv.vo.shop;

import cn.chouyv.domain.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商铺信息返回体
 *
 * @Author: wang
 * @Date: 2023/08/11/10:56
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopListInfoVO {
    private long id;
    private String nickname;
    private String address;
    private String phone;

    /**
     * 由商店转成ShopListInfoVO
     *
     * @param shop 商店
     * @return {@link ShopListInfoVO}
     */
    public static ShopListInfoVO byShop(Shop shop) {
        return new ShopListInfoVO(
                shop.getId(),
                shop.getNickname(),
                shop.getAddress(),
                shop.getPhone()
        );
    }
}
