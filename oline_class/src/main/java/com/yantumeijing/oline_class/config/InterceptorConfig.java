package com.yantumeijing.oline_class.config;

import com.yantumeijing.oline_class.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 * <p>
 * 不用配置可以访问:    /api/v1/pub
 * 需要配置权限的:     /api/v1/pri
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")//需要拦截
                .excludePathPatterns("/api/v1/pri/user/register", "/api/v1/pri/user/login");//不需要拦截
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
