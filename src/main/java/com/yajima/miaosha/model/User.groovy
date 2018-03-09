package com.yajima.miaosha.model

/**
 * Created by xu on 2018/1/17.
 */
class User {
    Long id
    String name

    User(Long id, String name) {
        this.id = id
        this.name = name
    }

    User() {
    }
}
