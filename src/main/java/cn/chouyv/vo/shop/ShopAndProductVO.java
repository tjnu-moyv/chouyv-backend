package cn.chouyv.vo.shop;

import cn.chouyv.domain.Shop;
import cn.chouyv.domain.ShopProducts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商店和产品响应
 * Created with IntelliJ IDEA.
 *
 * @author 17986
 * @Author: wang
 * @Date: 2023/08/10/16:04
 * @Description:
 * @date 2023/08/10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopAndProductVO {

    private OneShopInfo shop;
    private List<OneShopProductsInfo> shopProducts;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OneShopInfo {
        private String address;
        private long id;
        private String nickname;
        /**
         * 商家联系电话
         */
        private String phone;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OneShopProductsInfo {
        private long count;
        private String description;
        private long id;
        private String imgUrl;
        private String name;
        private long price;
    }

    public static OneShopInfo oneShopInfo(Shop shop) {
        return new ShopAndProductVO.OneShopInfo(
                shop.getAddress(),
                shop.getId(),
                shop.getNickname(),
                shop.getPhone()
        );
    }

    public static List<OneShopProductsInfo> shopProductsInfoList(List<ShopProducts> list) {
        return list.stream().map(shopProducts -> new OneShopProductsInfo(
                shopProducts.getCount(),
                shopProducts.getDescription(),
                shopProducts.getId(),
                shopProducts.getImgUrl(),
                shopProducts.getName(),
                shopProducts.getPrice()
        )).collect(Collectors.toList());
    }

}
