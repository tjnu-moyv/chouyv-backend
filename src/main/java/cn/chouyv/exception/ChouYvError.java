package cn.chouyv.exception;

/**
 * @author SurKaa
 */
public enum ChouYvError {

    SYSTEM_ERROR(-1, "服务器故障, 请联系开发者修复"),
    SUCCESS(200, "成功"),
    REGISTER_ERROR(300, "注册失败"),
    LOGIN_ERROR(301, "登录失败"),
    TOKEN_ERROR(302, "登陆过期, 请重新登录"),
    SHOP_INFO_EMPTY(303, "无法获取商铺信息"),
    UPDATE_ERROR(304, "更新失败"),
    NO_MONEY_ERROR(305, "余额不足"),
    ORDER_NOT_PAY(306, "订单未支付"),

    SELECT_ORDER_WITH_WRONG_TOKEN(307,"错误的权限")
    ;


    private final int code;
    private final String message;

    ChouYvError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
