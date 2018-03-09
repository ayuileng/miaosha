package com.yajima.miaosha.service;

import com.yajima.miaosha.common.Md5Util;
import com.yajima.miaosha.common.ResponseCode;
import com.yajima.miaosha.common.ServerResponse;
import com.yajima.miaosha.dao.MiaoshaUserMapper;
import com.yajima.miaosha.model.MiaoshaUser;
import com.yajima.miaosha.vo.LoginVo;
import com.yajima.miaosha.vo.RegisterVo;
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
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.USER_NOT_EXIST.getCode(), ResponseCode.USER_NOT_EXIST.getDesc());
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

    public ServerResponse<String> register(RegisterVo registerVo) {
        if(registerVo==null){
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.REGISTER_FAIL.getCode(),ResponseCode.REGISTER_FAIL.getDesc());
        }
        MiaoshaUser miaoshaUser = miaoshaUserMapper.selectByPrimaryKey(registerVo.getMobile());
        if(miaoshaUser!=null){
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.USER_EXIST.getCode(),ResponseCode.USER_EXIST.getDesc());
        }
        MiaoshaUser user = new MiaoshaUser();
        user.setId(registerVo.getMobile());
        user.setNickname(registerVo.getNickname());
        user.setRegisterDate(new Date());
        user.setLoginCount(1);
        user.setLastLoginDate(new Date());
        String salt = Md5Util.md5Encoder(registerVo.getNickname(), "").substring(0, 6);
        user.setSalt(salt);
        String dbPassword = Md5Util.md5Encoder(registerVo.getPassword(), salt);
        user.setPassword(dbPassword);
        user.setGravatar("https://www.gravatar.com/avatar/"+dbPassword);
        miaoshaUserMapper.insert(user);
        return ServerResponse.createBySuccess("register success");
    }
}
