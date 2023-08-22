package cn.chouyv.vo.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

}
