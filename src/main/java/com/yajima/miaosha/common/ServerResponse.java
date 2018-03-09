package com.yajima.miaosha.common;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable {
    private Integer status;
    private String msg;
    private T data;

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    @JSONField(serialize = false)
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    private ServerResponse(Integer status) {
        this.status = status;
    }

    private ServerResponse(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    public static <T> ServerResponse<T> createBySuccess(){
        return  new ServerResponse<>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc());
    }
    public static <T> ServerResponse<T> createBySuccess(String msg){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    public static <T> ServerResponse<T> createByErrorMsg(String msg){
        return new ServerResponse<>(ResponseCode.ERROR.getCode(),msg);
    }
    public static <T> ServerResponse<T> createByErrorCodeAndMsg(Integer code,String msg){
        return new ServerResponse<>(code,msg);
    }
}
