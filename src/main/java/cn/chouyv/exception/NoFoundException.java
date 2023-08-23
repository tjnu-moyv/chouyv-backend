package cn.chouyv.exception;

/**
 * 没有发现异常
 *
 * @author SurKaa
 * @date 2023/08/23
 */
public class NoFoundException extends ChouYvException {
    public NoFoundException(String message, int code, String description) {
        super(message, code, description);
    }

    public static NoFoundException error(String description) {
        return new NoFoundException(
                ChouYvError.NO_FOUND_ERROR.getMessage(),
                ChouYvError.NO_FOUND_ERROR.getCode(),
                description
        );
    }
}
