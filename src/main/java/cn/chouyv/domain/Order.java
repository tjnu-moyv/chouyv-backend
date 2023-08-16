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
     * 订单状态
     * <ul>
     *      <li>-1 - 异常(支付时间过期, 订单取消)</li>
     *      <li>1 - 待支付</li>
     *      <li>2 - 已支付(没人接单)</li>
     *      <li>3 - 备餐中(有人接单才能通知商家备餐)</li>
     *      <li>4 - 等待跑腿的取(备餐已完成)</li>
     *      <li>5 - 配送中</li>
     *      <li>6 - 商品已到达</li>
     * </ul>
     */
    private Integer status;

    /**
     * 异常(支付时间过期, 订单取消)
     */
    public static final int STATUS_ERROR = -1;
    /**
     * 待支付
     */
    public static final int STATUS_WAIT_PAY = 1;
    /**
     * 已支付(没人接单)
     */
    public static final int STATUS_PAID = 2;
    /**
     * 备餐中(有人接单才能通知商家备餐)
     */
    public static final int STATUS_WAIT_DONE = 3;
    /**
     * 等待跑腿的取(备餐已完成)
     */
    public static final int STATUS_WAIT_GET_BY_RUNNER = 4;
    /**
     * 配送中
     */
    public static final int STATUS_RUNNING = 5;
    /**
     * 商品已到达
     */
    public static final int STATUS_OK = 6;

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