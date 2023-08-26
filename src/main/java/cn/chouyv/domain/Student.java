package cn.chouyv.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 *
 * @author SurKaa
 * @TableName student
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "student")
public class Student implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 2359052728423062590L;

    public Student(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /**
     * 密码脱敏
     *
     * @param student 学生
     * @return {@link Student}
     */
    public static Student safe(Student student) {
        Student res = new Student();
        res.id = student.id;
        res.username = student.username;
        // res.password = student.password;
        res.role = student.role;
        res.createdAt = student.createdAt;
        res.updatedAt = student.updatedAt;
        res.isDeleted = student.isDeleted;
        return res;
    }

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

    public static final int ROLE_STUDENT = 0;
    public static final int ROLE_RUNNER = 1;

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