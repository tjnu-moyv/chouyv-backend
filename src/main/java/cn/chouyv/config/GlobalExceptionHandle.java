package cn.chouyv.config;

import cn.chouyv.exception.ChouYvException;
import cn.chouyv.utils.Result;
import cn.chouyv.vo.BaseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常拦截
 *
 * @author SurKaa
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(ChouYvException.class)
    public BaseVO<Object> userCenterException(ChouYvException e) {
        log.error("ChouYv错误: ", e);
        return Result.fail(e);
    }

    @ExceptionHandler(Exception.class)
    public BaseVO<Object> exception(Exception e) {
        log.error("Exception: ", e);
        return Result.fail("服务器内部故障, 请稍后再试");
    }

}
