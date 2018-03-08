package com.yajima.miaosha.web;

import com.yajima.miaosha.model.User;
import com.yajima.miaosha.redis.RedisService;
import com.yajima.miaosha.redis.keys.UserKey;
import com.yajima.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xu on 2018/1/17.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RedisService redisService;

    @GetMapping("/insert1")
    public String insert(){
        User user = new User();
        user.setId(1L);
        user.setName("yajima");
        userService.insert(user);
        return "insert success";
    }
    @GetMapping("/ge1t/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @RequestMapping("/get/{id}")
    public User redisGet(@PathVariable("id") Long id) {
        User user = redisService.get(UserKey.getById, "" + id, User.class);
        return user;
    }

    @RequestMapping("/set/{id}")
    public Boolean redisSet(@PathVariable("id")Long id) {
        User user = new User();
        user.setId(id);
        user.setName("name"+id);
        redisService.set(UserKey.getById,""+id,user);
        return true;
    }
}
