package com.ws.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoginAspect {

    @Before("@annotation(com.ws.interceptor.annotation.RequestLogin)")
    public void beforeMethodRequiresLoginAnnotation(){
        log.info("验证用户登录权限");
        // 在这里执行登录权限验证逻辑
        // 可以从会话中获取登录状态或检查用户的身份验证信息
        // 如果验证不通过，可以抛出异常或执行其他操作
    }

}
