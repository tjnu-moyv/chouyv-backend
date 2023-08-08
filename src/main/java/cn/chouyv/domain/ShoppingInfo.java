package cn.chouyv.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户的收货地址信息表
 * @author SurKaa
 * @TableName shopping_info
 */
@TableName(value ="shopping_info")
@Data
public class ShoppingInfo implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = -2059280749867253123L;

    /**
     * 收货信息主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户主键
     */
    private Long uid;

    /**
     * 收获姓名
     */
    private String name;

    /**
     * 收货地址
     */
    private String location;

    /**
     * 联系电话
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
    private Integer isDeleted;
}