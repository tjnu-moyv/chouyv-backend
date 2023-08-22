package cn.chouyv.exception;

/**
 * 获取商店信息时发生错误
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/10/17:13
 * @Description:
 */
public class ShopDetailException extends ChouYvException {
    public ShopDetailException(String message, int code, String description) {
        super(message, code, description);
    }

    /**
     * 获取商店信息时发生错误
     *
     * @param description 错误原因(传入的参数问题)
     * @return error
     */
    public static ShopDetailException error(String description) {
        return new ShopDetailException(
                ChouYvError.SHOP_DETAIL_EMPTY.getMessage(),
                ChouYvError.SHOP_DETAIL_EMPTY.getCode(),
                description
        );
    }
}
