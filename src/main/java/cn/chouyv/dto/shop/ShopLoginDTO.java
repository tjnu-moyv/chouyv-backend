package cn.chouyv.dto.shop;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 81047
 */
@Data
public class ShopLoginDTO implements Serializable {

    private static final long serialVersionUID = -4822032801251789016L;

    private String username;
    private String password;
}
