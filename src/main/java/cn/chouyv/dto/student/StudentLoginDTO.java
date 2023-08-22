package cn.chouyv.dto.student;

import lombok.Data;

import java.io.Serializable;

/**
 * @author SurKaa
 */
@Data
public class StudentLoginDTO implements Serializable {

    private static final long serialVersionUID = -4822032801251789016L;

    private String username;
    private String password;
}
