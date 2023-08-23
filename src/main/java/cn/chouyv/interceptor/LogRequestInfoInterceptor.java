package cn.chouyv.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 用于记录每次请求
 * <p>
 * 内容包括:
 * <ul>
 *     <li>每个请求生成一个uuid</li>
 *     <li>路径</li>
 *     <li>方法</li>
 *     <li>参数(所有方法的所有参数)</li>
 *     <li>ip地址</li>
 *     <li>响应时间</li>
 * </ul>
 *
 * @author SurKaa
 */
@Slf4j
public class LogRequestInfoInterceptor implements HandlerInterceptor {

    /**
     * 前处理
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理程序
     * @return boolean
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 生成一个UUID作为请求ID
        String requestId = UUID.randomUUID().toString();
        // 记录到request中
        request.setAttribute("uuid", requestId);

        // 获取请求路径、方法、参数、IP地址等信息
        String requestPath = request.getRequestURI();
        String requestMethod = request.getMethod();
        String requestParameters = request.getQueryString(); // This gets the query parameters
        String ipAddress = request.getRemoteAddr();

        // 记录请求开始时间
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        log.info("Request[{}] - Path: {}, Method: {}, Parameters: {}, IP: {}",
                requestId, requestPath, requestMethod, requestParameters, ipAddress);

        return true; // 继续处理请求链
    }

    /**
     * 处理后
     * Controller 处理结束之后执行 又在真正返回处理结果之前执行
     *
     * @param request      请求
     * @param response     响应
     * @param handler      处理程序
     * @param modelAndView 模型和视图
     * @throws Exception 异常
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    /**
     * 完成后
     * 整个处理结束之后(返回处理结果之后)执行 可用于清理资源
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理程序
     * @param ex       发生的异常
     * @throws Exception 异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 获取uuid
        String uuid = (String) request.getAttribute("uuid");

        // 计算请求处理时间
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        log.info("Request[{}] - processing time: {} ms", uuid, elapsedTime);

        // 此处可以进行一些资源清理操作
    }
}
