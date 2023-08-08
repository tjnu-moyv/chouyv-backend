package cn.chouyv.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商家表
 * @author SurKaa
 * @TableName shop
 */
@TableName(value ="shop")
@Data
public class Shop implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 163900429470040428L;

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
    private Integer isDeleted;
}