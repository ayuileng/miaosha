package com.yajima.miaosha.redis

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Created by xu on 2018/1/19.
 */
@Component
@ConfigurationProperties(prefix = "redis")
class RedisConfig {
    String host;
    int port;
    int timeout;//秒
    String password;
    int poolMaxTotal;
    int poolMaxIdle;
    int poolMaxWait;//秒
}
