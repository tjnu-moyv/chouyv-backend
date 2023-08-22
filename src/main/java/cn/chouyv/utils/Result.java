package cn.chouyv.utils;

import cn.chouyv.exception.ChouYvError;
import cn.chouyv.exception.ChouYvException;
import cn.chouyv.vo.BaseResponse;

/**
 * @author SurKaa
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/09/17:19
 * @Description:
 */
public class Result {

    public static final int SUCCESS_CODE = ChouYvError.SUCCESS.getCode();

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
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(SUCCESS_CODE, data, null, null);
    }

}
