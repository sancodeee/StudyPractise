package com.ws.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class firstAspect {

    //execution表达式：第一个*表示返回值类型任意 ，com.ws.service表示包名，后面的..表示当前包及子包，后边的*表示类名任意，之后的*表示方法名任意
    // (..)括号表示参数，..表示参数任意
    @Pointcut("execution(* com.ws.service..*.*(..))")
    public void pointcut(){

    }


}
