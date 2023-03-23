package com.ws.jdkDynamicProxy;

import java.lang.reflect.Proxy;

//基于接口的动态代理：jdk动态代理

public class jdkDynamicTest {
  public static void main(String[] args) {

        //源对象入参
        //JdkProxy为代理对象要做的事情
        JdkProxy jdkProxy = new JdkProxy(new Student("张三"));

        /**
         * 创建源对象的代理对象
         * 参数一：类加载器
         * 参数二：对象的接口
         * 参数三：调用处理器，代理对象中的方法被调用，都会在执行方法。对所有被代理对象的方法进行拦截
         */
        Person student = (Person) Proxy.newProxyInstance(jdkProxy.getClass().getClassLoader(), new Class[]{Person.class}, jdkProxy);
        //代理对象student调用了wakeup()方法，则代理对象要做的事情就是jdkProxy中设定好的事情
        student.wakeup();
        //代理对象调用了sleep()方法
        student.sleep();

    }
}
