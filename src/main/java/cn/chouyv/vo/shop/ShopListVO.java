package cn.chouyv.vo.shop;

import cn.chouyv.domain.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

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
public class ShopListVO {
    public List<ShopListInfoVO> shops;

    public static List<ShopListInfoVO> shopListInfo(List<Shop> shopList) {
        return shopList
                .stream()
                .map(ShopListInfoVO::byShop)
                .collect(Collectors.toList());
    }
}


