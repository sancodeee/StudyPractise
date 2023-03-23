package com.ws.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//基于代理的处理程序
public class MyInvocation implements InvocationHandler {

    //要针对谁产生代理 ：BookDao
    //因为代理角色可以是任意java类型，所以用Object
    private Object object;

    public MyInvocation(Object object){
        this.object = object;
    }

    //方法的返回值就是代理对象
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用某个方法前做的事
        System.out.println("权限校验") ;

        //调用接口的列表自己的方法:update(),delete(),add(),select()
        //方法调用：代理对象调用真实对象的某个方法
        Object obj = method.invoke(object, args);

        //调用某个方法后做的事
        System.out.println("产生日志文件");
        return obj;
    }

}
