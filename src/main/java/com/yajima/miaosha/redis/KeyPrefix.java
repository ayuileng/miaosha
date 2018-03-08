package com.yajima.miaosha.redis;

/**
 * Created by xu on 2018/1/19.
 * redis保存的时候的key的前缀
 */
public interface KeyPrefix {
    int getExpireSeconds();//过期时间
    String getPrefix();

}
