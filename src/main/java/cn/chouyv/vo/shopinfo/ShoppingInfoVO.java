package cn.chouyv.vo.shopinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 收货地址返回体
 *
 * @author SurKaa
 */
@Data
public class ShoppingInfoVO implements Serializable {

    private static final long serialVersionUID = 484823876970528285L;

    private long id;
    private String name;
    private String location;
    private String phone;

}
