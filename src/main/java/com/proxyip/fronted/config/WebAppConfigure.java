package com.proxyip.fronted.config;

import com.proxyip.fronted.interceptor.AjaxInterceptor;
import com.proxyip.fronted.interceptor.GlobalInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebAppConfigure implements WebMvcConfigurer {

    @Resource
    private AjaxInterceptor ajaxInterceptor;

    @Resource
    private GlobalInterceptor globalInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ajaxInterceptor)
                .addPathPatterns("/api/**").excludePathPatterns("/static/**");
        registry.addInterceptor(globalInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**");
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("claspath:/static/layui/");
    }


}
