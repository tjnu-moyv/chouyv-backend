package cn.chouyv.exception;

/**
 * 密码错误
 *
 * @author SurKaa
 */
public class PwdException extends ChouYvException {
    public PwdException(String message, int code, String description) {
        super(message, code, description);
    }

    public static PwdException error(String description) {
        return new PwdException(
                ChouYvError.PASSWORD_ERROR.getMessage(),
                ChouYvError.PASSWORD_ERROR.getCode(),
                description
        );
    }

    public static PwdException error() {
        return error(null);
    }

}
