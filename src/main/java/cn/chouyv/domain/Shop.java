package cn.chouyv.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 商家表
 *
 * @author SurKaa
 * @TableName shop
 */
@TableName(value = "shop")
@Data
public class Shop implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 163900429470040428L;

    /**
     * 密码脱敏
     *
     * @param shop 商铺
     * @return 脱敏后的
     */
    public static Shop safe(Shop shop) {
        Shop res = new Shop();
        res.id = shop.id;
        res.username = shop.username;
        // res.password = shop.password;
        res.nickname = shop.nickname;
        res.address = shop.address;
        res.phone = shop.phone;
        res.createdAt = shop.createdAt;
        res.updatedAt = shop.updatedAt;
        res.isDeleted = shop.isDeleted;
        return res;
    }

    /**
     * 商家主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 商家登陆账号
     */
    private String username;

    /**
     * 商家登陆密码
     */
    private String password;

    /**
     * 商家名称
     */
    private String nickname;

    /**
     * 商家地址
     */
    private String address;

    /**
     * 商家联系电话
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 逻辑删除 0-未删除 1-已删除
     */
    @TableLogic
    private Integer isDeleted;
}