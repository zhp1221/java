package com.zhanghp.config;

import com.zhanghp.interceptor.TenantInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhanghp
 * @date 2023-11-25 16:53
 */
@Configuration
public class CustomInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getRequestContextInterceptor());
    }

    @Bean
    public TenantInterceptor getRequestContextInterceptor() {
        return new TenantInterceptor();
    }
}
