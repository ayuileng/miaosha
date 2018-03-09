package com.yajima.miaosha.redis.keys;

import com.yajima.miaosha.redis.BasePrefix;

/**
 * Created by xu on 2018/1/19.
 */
public class MiaoshaUserKey extends BasePrefix{

    public MiaoshaUserKey(int expireSeconds,String prefix) {
        super(expireSeconds,prefix);
    }
    public static MiaoshaUserKey token = new MiaoshaUserKey(3600*24*2,"token");
}
