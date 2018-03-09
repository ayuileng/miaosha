package com.yajima.miaosha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    MiaoshaUserArgumentResolver miaoshaUserArgumentResolver;
    /**
     * controller中的方法可以任意添加参数，比如Model，response等等，都是通过这个方法实现的
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        //自定义一个MiaoshaUser的参数解析器,能够从httprequest中自动将相应的数据封装成对象参数
        argumentResolvers.add(miaoshaUserArgumentResolver);
    }
}
