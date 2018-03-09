package com.yajima.miaosha.web;

import com.yajima.miaosha.common.ServerResponse;
import com.yajima.miaosha.redis.RedisService;
import com.yajima.miaosha.service.MiaoshaUserService;
import com.yajima.miaosha.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public ServerResponse<String> login(LoginVo loginVo) {
        logger.info(loginVo.toString());
        return miaoshaUserService.login(loginVo);
    }

    @GetMapping("/login")
    public ServerResponse<Boolean> register() {
        return ServerResponse.createBySuccess();
    }


}
