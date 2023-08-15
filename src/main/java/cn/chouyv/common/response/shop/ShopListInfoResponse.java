package cn.chouyv.common.response.shop;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/11/10:56
 * @Description:
 */
@Data
public class ShopListInfoResponse {
    private long id;
    private String nickname;
    private String address;
    private String phone;
}
