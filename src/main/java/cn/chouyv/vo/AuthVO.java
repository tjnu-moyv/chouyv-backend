package cn.chouyv.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 登陆注册返回体
 *
 * @author SurKaa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthVO implements Serializable {

    private static final long serialVersionUID = 5019590273968922269L;

    private Long id;
    private String username;
    private String token;

}
