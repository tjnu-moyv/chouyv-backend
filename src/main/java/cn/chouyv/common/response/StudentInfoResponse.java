package cn.chouyv.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 学生用户信息返回体
 *
 * @author SurKaa
 */
@Data
public class StudentInfoResponse implements Serializable {

    private static final long serialVersionUID = -6666415261780399878L;

    private long id;
    private String username;
    private int role;
    private String createdAt;
    private long shoppingInfoId;
    private StudentInfoResponse[] arrayOfShoppingInfo;

}
