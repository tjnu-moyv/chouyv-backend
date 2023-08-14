package cn.chouyv.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/14/16:09
 * @Description:
 */
public class SelectWithoutPermissionException extends ChouYvException{
    public SelectWithoutPermissionException(String message, int code, String description) {
        super(message, code, description);
    }
    public static SelectWithoutPermissionException error(String description){
        return new SelectWithoutPermissionException(
                ChouYvError.SELECT_ORDER_WITH_WRONG_TOKEN.getMessage(),
                ChouYvError.SELECT_ORDER_WITH_WRONG_TOKEN.getCode(),
                description
        );
    }
}
