package com.yajima.miaosha.vo;

import com.yajima.miaosha.common.IsMobile;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class LoginVo implements Serializable{

    @IsMobile           //自定义验证
    private Long mobile;

    @NotBlank
    private String password;

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
