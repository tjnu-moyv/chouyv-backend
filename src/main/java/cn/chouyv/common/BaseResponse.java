package cn.chouyv.common;

import cn.chouyv.exception.ChouYvException;
import com.fasterxml.jackson.databind.ser.Serializers;
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

    /**
     * 错误返回体
     *
     * @param message     错误信息
     * @param description 错误详情
     * @return 返回体
     */
    public static BaseResponse<Object> fail(String message, String description) {
        return new BaseResponse<>(-1, null, message, description);
    }

    /**
     * 错误返回体
     *
     * @param message 错误信息
     * @return 返回体
     */
    public static BaseResponse<Object> fail(String message) {
        return new BaseResponse<>(-1, null, message, null);
    }

    /**
     * 错误返回体
     *
     * @param e 错误异常
     * @return 返回体
     */
    public static BaseResponse<Object> fail(ChouYvException e) {
        return new BaseResponse<>(e.getCode(), null, e.getMessage(), e.getDescription());
    }

    /**
     * 成功返回体
     *
     * @param data 返回数据
     * @param <T>  返回数据的类型
     * @return 返回体
     */
    public <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, null, null);
    }


    /**
     * 成功（指定code）
     *
     * @param code 代码
     * @param data 数据
     * @return {@link BaseResponse}<{@link T}>
     */

    public   BaseResponse<T> success(Integer code,T data){
        return new BaseResponse(code,data,null,null);
    }
}
