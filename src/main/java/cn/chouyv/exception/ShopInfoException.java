package cn.chouyv.exception;


/**
 * 获取收货地址时发生错误
 *
 * @author SurKaa
 */
public class ShopInfoException extends ChouYvException {
    public ShopInfoException(String message, int code, String description) {
        super(message, code, description);
    }

    /**
     * 获取收货地址时发生错误
     *
     * @param description 错误原因(传入的参数问题)
     * @return error
     */
    public static ShopInfoException error(String description) {
        return new ShopInfoException(
                ChouYvError.SHOP_INFO_ERROR.getMessage(),
                ChouYvError.SHOP_INFO_ERROR.getCode(),
                description
        );
    }


    /**
     * 获取收货地址时发生错误
     *
     * @return error
     */
    public static ShopInfoException errorWithNoLogin() {
        return new ShopInfoException(
                ChouYvError.SHOP_INFO_ERROR.getMessage(),
                ChouYvError.SHOP_INFO_ERROR.getCode(),
                "没有找到登录账户, 请重新登录"
        );
    }
}
