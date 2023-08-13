package cn.chouyv.config;

import cn.chouyv.interceptor.AuthCheckInterceptor;
import cn.chouyv.utils.JwtHandle;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author SurKaa
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private final JwtHandle jwtHandle;

    public InterceptorConfig(JwtHandle jwtHandle) {
        this.jwtHandle = jwtHandle;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthCheckInterceptor(jwtHandle));
    }
}
