package com.ws.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//基于接口的动态代理：jdk动态代理--必须要实现接口
public class jdkDynamicTest2 {

    public static void main(String[] args) {
        //创建代理对象
        Person proxyInstance = (Person)jdkDynamicTest2.proxyInstance(new Student("李四"));
        //调用wakeup方法
        proxyInstance.wakeup();
        //调用sleep方法
        proxyInstance.sleep();

    }

    //该方法设定了代理对象要做的事，并返回一个代理对象
    public static Object proxyInstance(Object obj){

        //创建代理对象，并规定好代理对象要做的事
        /**
         * 创建源对象的代理对象
         * 参数一：类加载器
         * 参数二：对象的接口
         * 参数三：调用处理器，代理对象中的方法被调用，都会在执行方法。对所有被代理对象的方法进行拦截
         */
        Object proxyInstance = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //调用源对象的方法前要做什么
                System.out.println("调用方法前执行的...");
                //调用源对象的方法
                Object invoke = method.invoke(obj);
                //调用源对象方法后要做什么
                System.out.println("调用方法后执行的...");
                //返回调用
                return invoke;
            }
        });

        //返回代理对象
        return proxyInstance;
    }

}
