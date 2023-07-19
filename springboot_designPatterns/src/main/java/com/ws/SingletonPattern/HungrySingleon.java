package com.ws.SingletonPattern;

/**
 * 饿汉模式
 * 定义对象的同时，实例化该对象，所以在类加载阶段，该对象就被加载到内存中了
 */
public class HungrySingleon {

    private static HungrySingleon instance = new HungrySingleon();

    private HungrySingleon() {
    }

    //对外暴露创建实例的唯一接口方法
    public static HungrySingleon getInstance() {
        return instance;
    }

}