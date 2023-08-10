package cn.chouyv.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户信息表
 *
 * @author SurKaa
 * @TableName student
 */
@TableName(value = "student")
@Data
public class Student implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 2359052728423062590L;

    /**
     * 学生主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 学生登陆账号
     */
    private String username;

    /**
     * 学生登陆密码
     */
    private String password;

    /**
     * 用户角色 0-学生(正常消费者) 1-消费者and跑腿
     */
    private Integer role;

    /**
     * 收货地址外键
     */
    private Long shoppingInfoId;

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