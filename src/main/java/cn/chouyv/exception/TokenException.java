package cn.chouyv.exception;

/**
 * 鉴权时发生的错误
 *
 * @author SurKaa
 */
public class TokenException extends ChouYvException {
    public TokenException(String message, int code, String description) {
        super(message, code, description);
    }

    /**
     * 发生鉴权错误
     *
     * @param description 错误原因(传入的参数问题)
     * @return error
     */
    public static TokenException error(String description) {
        return new TokenException(
                ChouYvError.TOKEN_ERROR.getMessage(),
                ChouYvError.TOKEN_ERROR.getCode(),
                description
        );
    }
}
