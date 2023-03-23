package com.ws.dynamicProxy;


import com.ws.dynamicProxy.dao.BookDao;
import com.ws.dynamicProxy.dao.impl.BookDaoImpl;
import com.ws.dynamicProxy.dao.impl.BookDaoImpl2;

import java.lang.reflect.Proxy;

public class JdkDynamicProxy {
    public static void main(String[] args) {
        //接口多态:测试UserDao
        BookDao bookDao = new BookDaoImpl(); //真实角色
        //版本1:现在需要对功能增强,这个代码不合适!
        bookDao.add();
        bookDao.update();
        bookDao.query();
        bookDao.delete();
        System.out.println("----------------------------------");

        BookDao bookDao2 = new BookDaoImpl2();
        bookDao2.add();
        bookDao2.update();
        bookDao2.query();
        bookDao2.delete();

        System.out.println("----------------Jdk动态代理------------------");

        //前提是需要一个接口:UserDao
        MyInvocation myInvocation = new MyInvocation(bookDao);
        // public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
        BookDao proxyInstance = (BookDao) Proxy.newProxyInstance(
                bookDao.getClass().getClassLoader(),  //参数一：类加载器
                bookDao.getClass().getInterfaces(),   //参数二：源对象所实现的接口
                myInvocation);                             //参数三：代理对象要做的事
        proxyInstance.add();
        proxyInstance.update();
        proxyInstance.query();
        proxyInstance.delete();

    }
}
