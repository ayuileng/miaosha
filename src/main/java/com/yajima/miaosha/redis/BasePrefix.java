package com.yajima.miaosha.redis;

/**
 * Created by xu on 2018/1/19.
 * redis key前缀的基类，每个模块要用到的所有前缀都继承于这个类
 */
public abstract class BasePrefix implements KeyPrefix {
    private int expireSeconds;
    private String prefix;

    public BasePrefix( int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }
    public BasePrefix(String prefix) {//0代表永不过期
        this(0, prefix);
    }
    @Override
    public int getExpireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        return getClass().getSimpleName()+":"+prefix;
    }


}
