package com.yajima.miaosha.redis.keys;

import com.yajima.miaosha.redis.BasePrefix;

/**
 * Created by xu on 2018/1/19.
 */
public class UserKey extends BasePrefix{

    public UserKey(String prefix) {
        super(prefix);
    }
    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
