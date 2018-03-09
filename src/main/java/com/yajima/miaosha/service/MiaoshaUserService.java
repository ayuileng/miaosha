package com.yajima.miaosha.service;

import com.yajima.miaosha.common.Md5Util;
import com.yajima.miaosha.common.ResponseCode;
import com.yajima.miaosha.common.ServerResponse;
import com.yajima.miaosha.dao.MiaoshaUserMapper;
import com.yajima.miaosha.model.MiaoshaUser;
import com.yajima.miaosha.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MiaoshaUserService {
    @Autowired
    MiaoshaUserMapper miaoshaUserMapper;

    public MiaoshaUser getById(Long id) {
        return miaoshaUserMapper.selectByPrimaryKey(id);
    }


    public ServerResponse<String> login(LoginVo loginVo) {
        if (loginVo == null) {
            //登录失败
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.LOGIN_FAIL.getCode(), ResponseCode.LOGIN_FAIL.getDesc());
        }
        Long mobile = loginVo.getMobile();
        String password = loginVo.getPassword();//已经通过1次md5
        MiaoshaUser user = getById(mobile);
        if (user == null) {
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.USER_NOT_EXSIT.getCode(), ResponseCode.USER_NOT_EXSIT.getDesc());
        }
        String dbPassword = user.getPassword();
        //System.out.println("dbpass:"+dbPassword);
        String salt = user.getSalt();
        String realPassword = Md5Util.md5Encoder(password, salt);
        //System.out.println("real:"+realPassword);
        if (!realPassword.equals(dbPassword)) {
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.PASSWORD_ERROR.getCode(),ResponseCode.PASSWORD_ERROR.getDesc());
        }
        //登陆成功的处理
        user.setLastLoginDate(new Date());
        user.setLoginCount(user.getLoginCount()+1);
        miaoshaUserMapper.updateByPrimaryKey(user);
        return ServerResponse.createBySuccess();

    }
}
