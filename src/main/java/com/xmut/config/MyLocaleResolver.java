package com.xmut.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author
 * @date: 2023/12/29
 **/
//国际化的配置
public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言参数
        String language=request.getParameter("1");
        Locale locale=Locale.getDefault();//如果没有就使用默认的；
        //如果请求的链接携带了国际化参数
        if (!StringUtils.isEmpty(language)){
            //zh_CN
            String[] split=language.split("_");
            //国家。地区
            locale=new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
