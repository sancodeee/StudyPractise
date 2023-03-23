package com.ws.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//jdk动态代理
//统一代理
public class JdkProxy implements InvocationHandler {

    //真实角色
    private Object object;

    public JdkProxy(Object object) {
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //执行方法前
        String methodName = method.getName();
        if (methodName.equals("wakeup")) {
            System.out.println("早安~~~");
        } else if (methodName.equals("sleep")) {
            System.out.println("晚安~~~");
        }
        //执行方法的调用：代理对象调用的某个方法
        Object invoke = method.invoke(object, args);
        //执行方法后
        if (methodName.equals("wakeup")) {
            System.out.println("彻底醒了~~~");
        } else if (methodName.equals("sleep")) {
            System.out.println("彻底睡着了~~~");
        }
        return invoke;
    }
}
