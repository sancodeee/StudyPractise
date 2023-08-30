package com.ws.CreationalDesignPatterns.SingletonPattern;

/**
 * 静态内部类实现单例模式
 * 将对象的实例和初始化放在内部类中
 */
public class Singleton {

    public static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    //对外暴露的提供本类对象的唯一接口方法
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
