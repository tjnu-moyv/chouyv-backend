package cn.chouyv.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一的返回体
 *
 * @author SurKaa
 */
@Data
public class BaseResponse<T> implements Serializable {

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
