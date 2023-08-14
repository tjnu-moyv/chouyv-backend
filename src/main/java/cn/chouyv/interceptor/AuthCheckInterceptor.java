package cn.chouyv.interceptor;

import cn.chouyv.utils.JwtHandle;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 检测是否登陆了的鉴权拦截器
 *
 * @author SurKaa
 */
@Slf4j
public class AuthCheckInterceptor implements HandlerInterceptor {

    private final JwtHandle jwtHandle;

    public static final String[] NO_TOKEN_URL = {
            "/students/login",
            "/students/register",
            "/shops/login",
            "/shops/register",
    };

    public AuthCheckInterceptor(JwtHandle jwtHandle) {
        this.jwtHandle = jwtHandle;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) {
        String uri = request.getRequestURI();
        showRequestInfo(request);
        int i = 0;
        while (i < NO_TOKEN_URL.length) {
            if (uri.endsWith(NO_TOKEN_URL[i])) {
                log.debug("Login or register request");
                return true;
            }
            i++;
        }
        String token = request.getHeader("token");
        if (token != null && token.length() > 0) {
            JWT jwt = jwtHandle.validate(token);
            Object id = jwt.getPayload(JWTPayload.ISSUER);
            Object username = jwt.getPayload(JWTPayload.SUBJECT);
            request.setAttribute("id", id);
            request.setAttribute("username", username);
            return true;
        }
        return false;
    }

    private void showRequestInfo(HttpServletRequest request) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        String requestId = UUID.randomUUID().toString();
        String url = request.getRequestURI();
        String reqParam = "[" + request.getQueryString() + "]";
        log.info("Request start, id: {}, path: {}, ip: {}, params: {}", requestId, url,
                request.getRemoteHost(), reqParam);

        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();

            try {
                Object result = null;  // You need to adapt this part based on your use case
                // Uncomment and adapt the next line based on your specific context
                // Object result = proceedingJoinPoint.proceed();

                stopWatch.stop();
                long totalTimeMillis = stopWatch.getTotalTimeMillis();
                log.info("Request end, id: {}, cost: {}ms", requestId, totalTimeMillis);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
