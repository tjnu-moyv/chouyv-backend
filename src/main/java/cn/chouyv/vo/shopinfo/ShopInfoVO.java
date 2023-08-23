package cn.chouyv.vo.shopinfo;

import cn.chouyv.domain.ShoppingInfo;
import cn.chouyv.domain.Student;

import java.util.List;

/**
 * 商铺信息返回体
 *
 * @author 81047
 */
public class ShopInfoVO {

    private long id;
    private String username;
    private String nickname;
    private String address;
    private String phone;
    private List<ShoppingInfo> arrayOfShoppingInfo;

    public ShopInfoVO(Student student, List<ShoppingInfo> shoppingInfos) {
        this.id = student.getId();
        this.username = student.getUsername();
        this.arrayOfShoppingInfo = shoppingInfos;
    }

}
