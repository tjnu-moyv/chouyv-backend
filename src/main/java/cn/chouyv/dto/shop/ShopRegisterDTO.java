package cn.chouyv.dto.shop;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 81047
 */
@Data
public class ShopRegisterDTO implements Serializable {

    private static final long serialVersionUID = -7816389411291113132L;

    private String username;
    private String password;
    private String checkPwd;
}
