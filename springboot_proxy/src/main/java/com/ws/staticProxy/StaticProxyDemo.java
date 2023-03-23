package com.ws.staticProxy;

//静态代理：构造方法传参 通过构造方法将真实实例对象 传递给代理对象 然后通过调用代理对象实现了真实对象要做的事情

public class StaticProxyDemo {

    public static void main(String[] args) {

        //不使用静态代理的使用
        //真实实例
        System.out.println("---------------不使用代理--------------");
        You you = new You();
        you.mery();

        //使用静态代理
        System.out.println("--------------使用静态代理--------------");
        //创建真实对象
        You youu = new You();
        //创建代理角色
        WeddingCompany weddingCompany = new WeddingCompany(youu);
        weddingCompany.mery();

    }

}
