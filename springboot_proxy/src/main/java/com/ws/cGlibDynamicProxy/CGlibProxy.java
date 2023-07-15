package com.ws.cGlibDynamicProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理类
 */
//CGlib动态代理 ：属于第三方 CGLib ， 使用Enhancer创建代理对象
public class CGlibProxy implements MethodInterceptor {

    private Object object;

    public CGlibProxy(Object object) {
        this.object = object;
    }

    private Enhancer enhancer = new Enhancer();

    public Object getProxy() {
        //设置需要创建子类的类
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        //调用方法前
        System.out.println("调用方法前...");
        //调用方法
        Object invoke = method.invoke(object, objects);

        //调用方法后
        System.out.println("调用方法后...");
        return invoke;
    }
}
