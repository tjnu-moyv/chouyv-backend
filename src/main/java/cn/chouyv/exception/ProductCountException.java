package cn.chouyv.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/15/14:31
 * @Description:
 */
public class ProductCountException extends ChouYvException {
    public ProductCountException(String message, int code, String description) {
        super(message, code, description);
    }

    public static ProductCountException error(String description) {
        return new ProductCountException(
                ChouYvError.PRODUCT_COUNT_WRONG.getMessage(),
                ChouYvError.PRODUCT_COUNT_WRONG.getCode(),
                description
        );
    }
}
