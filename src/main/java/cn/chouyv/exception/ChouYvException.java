package cn.chouyv.exception;

/**
 * 统一的错误类型
 *
 * @author SurKaa
 */
public class ChouYvException extends RuntimeException {

    private final int code;

    private final String description;

    public ChouYvException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
