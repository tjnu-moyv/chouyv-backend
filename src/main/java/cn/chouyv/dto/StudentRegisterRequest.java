package cn.chouyv.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author SurKaa
 */
@Data
public class StudentRegisterRequest implements Serializable {

    private static final long serialVersionUID = -7816389411291113132L;

    private String username;
    private String password;
    private String checkPwd;
}
