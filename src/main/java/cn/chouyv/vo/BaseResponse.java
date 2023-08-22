package cn.chouyv.vo;

import lombok.Data;

/**
 * 统一的返回体
 *
 * @author SurKaa
 */
@Data
public class BaseResponse<T> {

    private int code;
    private T data;
    private String message;
    private String description;

    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }
}
