package cn.chouyv.common.shop;

import cn.chouyv.domain.ShopProducts;
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
public class ShopAndProductResponse {
    private ShopResponse shopResponse;
    private List<ShopProducts> shopProducts;


    public static ShopAndProductResponse toShopAndProductResponse(ShopResponse shopResponse, List<ShopProducts> shopProducts) {
        return new ShopAndProductResponse(shopResponse, shopProducts);
    }

}
