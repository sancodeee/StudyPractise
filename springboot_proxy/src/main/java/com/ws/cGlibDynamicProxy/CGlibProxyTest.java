package com.ws.cGlibDynamicProxy;

public class CGlibProxyTest {
    public static void main(String[] args) {


        CGlibProxy cGlibProxy = new CGlibProxy(new Student("李华"));

        Student proxy = (Student)cGlibProxy.getProxy();

        proxy.wakeup();

        proxy.sleep();

    }
}
