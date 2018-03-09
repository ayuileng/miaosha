package com.yajima.miaosha.exception;

import com.yajima.miaosha.common.ServerResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 全局控制器异常处理器
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ServerResponse<String> exceptionHandler(HttpServletRequest request,Exception e){
        //拦截到校验异常时通过aop来全局处理并返回
        if(e instanceof BindException){
            BindException ex = (BindException) e;
            List<ObjectError> allErrors = ex.getAllErrors();
            StringBuffer sb = new StringBuffer();
            for (ObjectError allError : allErrors) {
                sb.append(allError.getDefaultMessage());
                sb.append(" ");
            }
            return ServerResponse.createByErrorMsg(sb.toString());
        }else{
            return ServerResponse.createByError();
        }
    }
}
