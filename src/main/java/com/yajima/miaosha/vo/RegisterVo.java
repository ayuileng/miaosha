package com.yajima.miaosha.vo;

import com.yajima.miaosha.common.IsMobile;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class RegisterVo implements Serializable {
    @IsMobile
    private Long mobile;
    @NotBlank
    @Length(min = 4,max = 32)
    private String nickname;
    @NotBlank
    @Length(min = 6,max = 20)
    private String password;

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
