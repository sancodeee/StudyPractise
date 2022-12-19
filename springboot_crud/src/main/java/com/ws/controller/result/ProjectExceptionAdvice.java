package com.ws.controller.result;

import com.ws.Enum.ErrorCodes;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//为了使异常信息返回格式和非异常返回格式做到统一，需要做一个异常处理类
//异常处理器
//@ControllerAdvice
@RestControllerAdvice //该注解包含@ControllerAvice 比其多了responsebody
public class ProjectExceptionAdvice {

    //未指明异常类型 该注解拦截所有异常
    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        //打印异常信息
        e.printStackTrace();
        //统一异常返回到前端的格式 让格式一致
        return new Result(false,ErrorCodes.SERVER_ERROR.getErrorCode(),ErrorCodes.SERVER_ERROR.getErrorMessage());
    }

}
