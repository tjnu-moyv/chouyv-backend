package cn.chouyv.exception;

/**
 * 抛出注册异常
 *
 * @author SurKaa
 */
public class RegisterException extends ChouYvException {
    private RegisterException(String message, int code, String description) {
        super(message, code, description);
    }

    /**
     * 发生注册错误
     *
     * @param description 错误原因(传入的参数问题)
     * @return error
     */
    public static RegisterException error(String description) {
        return new RegisterException(
                ChouYvError.REGISTER_ERROR.getMessage(),
                ChouYvError.REGISTER_ERROR.getCode(),
                description
        );
    }
}
