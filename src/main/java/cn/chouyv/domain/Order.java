package cn.chouyv.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 订单表
 *
 * @author SurKaa
 * @TableName order
 */
@TableName(value = "order")
@Data
public class Order implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = -8489831941511702259L;

    /**
     * 订单主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 学生外键
     */
    private Long studentId;

    /**
     * 学生外键
     */
    private Long runId;

    /**
     * 商家外键
     */
    private Long shopId;

    /**
     * 商品总价
     */
    private Integer totalPrice;

    /**
     * 订单状态 0-备餐中 1-等待跑腿的取 2-配送中 3-商品已到达
     */
    private Integer status;

    /**
     * 订单的状态 0-堂食(用户取 食堂吃 不外带) 1-带走(打包, 需配送费) 2-找跑腿(run_id不可空)
     */
    private Integer type;

    /**
     * 预约时间
     */
    private Date targetTime;

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