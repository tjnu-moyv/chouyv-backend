package cn.chouyv.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author SurKaa
 * <p>
 * 订单商品表
 * @TableName order_shop_products_item
 */
@TableName(value = "order_shop_products_item")
@Data
public class OrderShopProductsItem implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = -5399360289737182613L;

    /**
     * 订单商品主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单外键
     */
    private Long orderId;

    /**
     * 商品外键
     */
    private Long shopProductsId;

    /**
     * 该商品的数量
     */
    private Integer count;

    /**
     * 该商品的备注
     */
    private String description;

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
    private Integer isDeleted;
}