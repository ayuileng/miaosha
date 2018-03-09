package com.yajima.miaosha.common;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

public class Md5Util {
    public static String md5Encoder(String rawString,String salt) {
        String after = salt + rawString + salt;
        return DigestUtils.md5Hex(after);
    }

    public static void main(String[] args){
        System.out.println("md5:"+Md5Util.md5Encoder("63178386@qq.com",""));
    }
}
