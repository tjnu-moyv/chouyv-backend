package cn.chouyv.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户钱包表
 *
 * @author SurKaa
 * @TableName money
 */
@TableName(value = "money")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Money implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1239788873637839048L;
    /**
     * 钱包主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户(学生 跑腿 商家等)id
     */
    private Long uid;

    /**
     * 人民币余额
     */
    private Long cny;

    /**
     * 人民币押金
     */
    private Integer depositCny;

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