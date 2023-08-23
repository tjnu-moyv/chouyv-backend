package cn.chouyv.dto.student;

import lombok.Data;

import java.io.Serializable;

/**
 * @author SurKaa
 */
@Data
public class StudentRegisterDTO implements Serializable {

    private static final long serialVersionUID = -7816389411291113132L;

    private String username;
    private String password;
    private String checkPwd;
}
