package com.yajima.miaosha.web;

import com.yajima.miaosha.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xu on 2018/1/17.
 */
@RestController
@RequestMapping("/user")
public class UserController {


//    @GetMapping("/insert1")
//    public String insert(){
//        User user = new User();
//        user.setId(1L);
//        user.setName("yajima");
//        userService.insert(user);
//        return "insert success";
//    }
//    @GetMapping("/ge1t/{id}")
//    public User getUserById(@PathVariable Long id){
//        return userService.getUserById(id);
//    }
//
//    @RequestMapping("/get/{id}")
//    public User redisGet(@PathVariable("id") Long id) {
//        User user = redisService.get(UserKey.getById, "" + id, User.class);
//        return user;
//    }
//
//    @RequestMapping("/set/{id}")
//    public Boolean redisSet(@PathVariable("id")Long id) {
//        User user = new User();
//        user.setId(id);
//        user.setName("name"+id);
//        redisService.set(UserKey.getById,""+id,user);
//        return true;
//    }
//    @GetMapping("/1")
//    public ServerResponse<String> testResponse(){
//        return ServerResponse.createBySuccess();
//    }
//    @GetMapping("/2")
//    public ServerResponse<User> testResponse1(){
//        return ServerResponse.createBySuccess(new User(1l,"yajima"));
//    }
//    @GetMapping("/3")
//    public ServerResponse<String> testResponse2(){
//        return ServerResponse.createBySuccess("successMsg");
//    }
//    @GetMapping("/4")
//    public ServerResponse<User> testResponse3(){
//        return ServerResponse.createBySuccess("userMsg",new User(2l,"suzuki"));
//    }
//    @GetMapping("/5")
//    public ServerResponse<String> testResponse4(){
//        return ServerResponse.createByError();
//    }
//    @GetMapping("/6")
//    public ServerResponse<User> testResponse5(){
//        return ServerResponse.createByErrorMsg("userErrorMsg");
//    }
//    @GetMapping("/7")
//    public ServerResponse<User> testResponse6(){
//        return ServerResponse.createByErrorCodeAndMsg(500,"server error");
//    }
}
