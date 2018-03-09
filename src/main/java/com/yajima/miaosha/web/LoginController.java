package com.yajima.miaosha.web;

import com.yajima.miaosha.common.ServerResponse;
import com.yajima.miaosha.redis.RedisService;
import com.yajima.miaosha.service.MiaoshaUserService;
import com.yajima.miaosha.vo.LoginVo;
import com.yajima.miaosha.vo.RegisterVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoggerFactory.class);
    @Autowired
    RedisService redisService;
    @Autowired
    MiaoshaUserService miaoshaUserService;

    @GetMapping("/to_login")
    public String tologin() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ServerResponse<String> login(@Valid LoginVo loginVo, HttpServletResponse response) {
        //参数校验,使用全局控制器增强来统一处理（aop）
        return miaoshaUserService.login(loginVo,response);
    }

    @GetMapping("/to_register")
    public String toRegister() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public ServerResponse<String> register(RegisterVo registerVo){
        return miaoshaUserService.register(registerVo);

    }


}
