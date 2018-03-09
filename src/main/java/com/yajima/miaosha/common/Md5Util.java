package com.yajima.miaosha.common;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

public class Md5Util {
    public static String md5Encoder(String rawString,String salt) throws UnsupportedEncodingException {
        String after = salt + rawString + salt;
        System.out.println(after);
        return DigestUtils.md5Hex(after);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("md5:"+Md5Util.md5Encoder("123456","1a2s3d4f"));
    }
}
