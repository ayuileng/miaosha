package com.yajima.miaosha.config;

import com.google.common.base.Strings;
import com.yajima.miaosha.model.MiaoshaUser;
import com.yajima.miaosha.redis.keys.MiaoshaUserKey;
import com.yajima.miaosha.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MiaoshaUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final String COOKIE_NAME_TOKEN = "token";
    @Autowired
    MiaoshaUserService miaoshaUserService;
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType() == MiaoshaUser.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        Cookie[] cookies = request.getCookies();
        String token = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(COOKIE_NAME_TOKEN)) {
                token = cookie.getValue();
            }
        }
        if(Strings.isNullOrEmpty(token)){
            return null;
        }
        return miaoshaUserService.getUserByToken(response,token);
    }
}
