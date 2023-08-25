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
    SHOP_DETAIL_EMPTY(303, "无法获取商铺信息"),
    UPDATE_ERROR(304, "更新失败"),
    NO_MONEY_ERROR(305, "余额不足"),
    ORDER_NOT_PAY(306, "订单未支付"),
    SELECT_ORDER_WITH_WRONG_TOKEN(307, "错误的权限"),
    MONEY_ERROR(308, "支付错误"),
<<<<<<< Updated upstream
    MONEY_COUNT_WRONG(309, "金额不合法"),
    PRODUCT_COUNT_WRONG(310, "数量非法"),
    SHOP_INFO_ERROR(311, "收获地址错误"),
    NO_FOUND_ERROR(312, "未找到"),
    PASSWORD_ERROR(313, "密码错误");
=======
    MONEY_COUNT_WRONG(309,"金额不合法"),
    PRODUCT_COUNT_WRONG(310,"数量非法"),
    DELETE_WITH_WRONG_TOKEN(311,"非法的删除请求")
    ;
>>>>>>> Stashed changes


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
