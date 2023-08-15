package cn.chouyv.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/15/14:27
 * @Description:
 */
public class MoneyCountError extends ChouYvException{
    public MoneyCountError(String message, int code, String description) {
        super(message, code, description);
    }
    public static MoneyCountError error(String description){
        return new MoneyCountError(ChouYvError.MONEY_COUNT_WRONG.getMessage(), ChouYvError.MONEY_ERROR.getCode(), description);
    }
}
