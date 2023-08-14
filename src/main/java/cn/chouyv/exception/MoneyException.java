package cn.chouyv.exception;

/**
 * 金钱异常
 *
 * @author SurKaa
 */
public class MoneyException extends ChouYvException {
    public MoneyException(String message, int code, String description) {
        super(message, code, description);
    }

    /**
     * 快速生成金钱异常
     *
     * @param description 详细信息
     * @return MoneyException
     */
    public static MoneyException error(String description) {
        return new MoneyException(
                ChouYvError.MONEY_ERROR.getMessage(),
                ChouYvError.MONEY_ERROR.getCode(),
                description
        );
    }

}
