package com.yajima.miaosha.service;

import com.yajima.miaosha.dao.UserMapper;
import com.yajima.miaosha.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xu on 2018/1/17.
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Transactional
    public void insert(User user){
        userMapper.insert(user);
    }

    public User getUserById(Long id){
        return userMapper.getUserById(id);
    }
}
