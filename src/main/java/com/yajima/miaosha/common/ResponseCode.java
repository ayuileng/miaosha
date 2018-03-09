package com.yajima.miaosha.common;

public enum ResponseCode {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(3,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(4,"ILLEGAL_ARGUMENT"),
    LOGIN_FAIL(5,"LOGIN_FAIL"),
    USER_NOT_EXIST(6,"USER_NOT_EXIST"),
    PASSWORD_ERROR(7,"PASSWORD_ERROR"),
    REGISTER_FAIL(8,"REGISTER_FAIL"),
    USER_EXIST(9,"USER_EXIST");
    private final Integer code;
    private final String desc;

    ResponseCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
