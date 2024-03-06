package com.xmut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author
 * @date: 2023/11/7
 **/
//扩展springmvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // public void addViewControllers(ViewControllerRegistry registry){
    //     registry.addViewController("/").setViewName("login");
    //     registry.addViewController("/login.html").setViewName("login");
    //     registry.addViewController("/index.html").setViewName("index");
    // }

    //自定义的国际化组件生效
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
    // //拦截器
    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     registry.addInterceptor(new LoginHandlerInterceptor())
    //             .addPathPatterns("/**")
    //             .excludePathPatterns("/login.html","/","/user/login","/css/*","/js/**","/img/**");//拦截所有，排除 "/index.html","/","/user/login"
    // }
}
