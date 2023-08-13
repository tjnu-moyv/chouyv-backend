package cn.chouyv.interceptor;

import cn.chouyv.utils.JwtHandle;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 检测是否登陆了的鉴权拦截器
 *
 * @author SurKaa
 */
@Slf4j
public class AuthCheckInterceptor implements HandlerInterceptor {

    private final JwtHandle jwtHandle;

    /**
     * 无需携带token的
     */
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
        log.info("新请求: {}", uri);
        int i = 0;
        while (i < NO_TOKEN_URL.length) {
            if (uri.endsWith(NO_TOKEN_URL[i])) {
                log.debug("登陆注册请求");
                return true;
            }
            i++;
        }
        String token = request.getHeader("token");
        if (token != null && token.length() > 0) {
            // 可能抛出异常
            JWT jwt = jwtHandle.validate(token);
            Object id = jwt.getPayload(JWTPayload.ISSUER);
            Object username = jwt.getPayload(JWTPayload.SUBJECT);
            // TODO 这样安全吗
            request.setAttribute("id", id);
            request.setAttribute("username", username);
            return true;
        }
        return false;
    }
}
