package com.lrh.blog.config;


import com.lrh.blog.handler.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //跨域配置，不可设置为*，不安全, 前后端分离项目，可能域名不一致
        //本地测试 端口不一致 也算跨域
        registry.addMapping("/**").allowedOrigins("*");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截test接口 后续实际遇到需要的 再配置
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/test").addPathPatterns("/comments/create/change").addPathPatterns("/articles/publish");
    }
}
