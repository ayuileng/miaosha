package com.yajima.miaosha.web;

import com.google.common.base.Strings;
import com.yajima.miaosha.model.MiaoshaUser;
import com.yajima.miaosha.redis.RedisService;
import com.yajima.miaosha.redis.keys.MiaoshaUserKey;
import com.yajima.miaosha.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/goods")
public class GoodsController {
    private final String COOKIE_NAME_TOKEN = "token";

    @Autowired
    MiaoshaUserService miaoshaUserService;

    /**
     * 这种写法的话在所有需要判断是否登录的方法都需要从cookie中取token，然后去redis中取user，然后判断user是否为空，很多重复的代码
     * 可以重写springmvc的addArgumentResolvers来实现
     *
     * @param token
     * @param model
     * @param response
     * @return
     */
    @GetMapping("/list")
    public String loList(@CookieValue(value = COOKIE_NAME_TOKEN) String token, Model model, HttpServletResponse response) {
//        String token = "";
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals(COOKIE_NAME_TOKEN)){
//                token = cookie.getValue();
//
//            }
//        }
        if (Strings.isNullOrEmpty(token)) {
            return "login";
        }
        MiaoshaUser user = miaoshaUserService.getUserByToken(response, token);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "goodsList";
    }

    @GetMapping("/list1")
    public String loList1(Model model, MiaoshaUser user) {

        model.addAttribute("user", user);
        return "goodsList";
    }
}
