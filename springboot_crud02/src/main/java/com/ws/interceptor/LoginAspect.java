package com.ws.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoginAspect {

    //定义切入点 自定义注解的方式标识切入点
    @Pointcut("@annotation(com.ws.interceptor.annotation.RequestLogin)")
    //execution表达式的方式标识拦截范围
//    @Pointcut("execution(* com.ws.controller..*.*(..))")
    public void pointCut(){
    }

    @Before("pointCut()")
//    @Before("@annotation(com.ws.interceptor.annotation.RequestLogin)")
    public void beforeMethodRequiresLoginAnnotation(JoinPoint joinPoint){
        // 在这里执行登录权限验证逻辑
        // 可以从会话中获取登录状态或检查用户的身份验证信息
        // 如果验证不通过，可以抛出异常或执行其他操作
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        log.info("验证用户登录权限");
        log.info("{}", joinPoint);
        log.info("获取被切的类 getTarget().getClass()：{}", joinPoint.getTarget().getClass());
        log.info("获取签名： getSignature()：{}", joinPoint.getSignature()); //通过签名可获取名称和参数类型
        log.info("获取方法名称：{}", joinPoint.getSignature().getName());
        log.info("获取参数类型：{}", signature.getParameterTypes());
        log.info("获取参数类型：{}", signature.getParameterNames());
        log.info("获取入参值 getArgs()：{}", joinPoint.getArgs());

    }

    @After("pointCut()")
    public void afterMethod(){
        log.info("方法调用完毕后执行...");
    }

}
