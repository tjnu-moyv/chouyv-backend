package cn.chouyv.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/15/14:27
 * @Description:
 */
public class MoneyCountException extends ChouYvException {
    public MoneyCountException(String message, int code, String description) {
        super(message, code, description);
    }

    public static MoneyCountException error(String description) {
        return new MoneyCountException(ChouYvError.MONEY_COUNT_WRONG.getMessage(), ChouYvError.MONEY_COUNT_WRONG.getCode(), description);
    }
}
