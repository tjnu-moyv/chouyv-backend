package cn.chouyv.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 账单表
 *
 * @author SurKaa
 * @TableName money_bill
 */
@TableName(value = "money_bill")
@Data
public class MoneyBill implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 3159109050208276585L;

    /**
     * 账单主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 转出账户
     */
    private Long fromId;

    /**
     * 转入账户
     */
    private Long toId;

    /**
     * 账单操作金额
     */
    private Integer money;

    /**
     * 转账类型 0-默认内部转账 1-充值(from_id = -1) 2-提现(to_id = -1)
     */
    private Integer type;

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