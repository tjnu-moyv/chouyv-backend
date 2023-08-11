package cn.chouyv.common.response;

import cn.chouyv.common.shop.ShopResponse;
import cn.chouyv.domain.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/11/11:06
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopListResponse {
    public List<ShopListInfoResponse> shopListInfoResponse;


    public static ShopListResponse toShopListResponse(List<ShopListInfoResponse> shopListInfoResponse){
        return new ShopListResponse(shopListInfoResponse);
    }
}


