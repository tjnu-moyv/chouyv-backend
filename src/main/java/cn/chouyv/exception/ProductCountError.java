package cn.chouyv.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/15/14:31
 * @Description:
 */
public class ProductCountError extends ChouYvException{
    public ProductCountError(String message, int code, String description) {
        super(message, code, description);
    }
    public static ProductCountError error(String description){
        return new ProductCountError(ChouYvError.PRODUCT_COUNT_WRONG.getMessage(), ChouYvError.PRODUCT_COUNT_WRONG.getCode(), description);

    }
}
