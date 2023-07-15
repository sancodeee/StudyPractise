package com.ws.SingletonPattern;

/**
 * 双重校验锁实现单例模式
 * 在懒汉模式的基础上进一步优化，给静态对象加上volatile关键字来保证初始化时对象的唯一性
 */
public class Lock2Singleton {

    //1.对象锁
    private volatile static Lock2Singleton instance;

    private Lock2Singleton() {
    }

    public static Lock2Singleton getSingleton() {
        if (instance == null) {
            synchronized (Singleton.class) {   //2.方法锁
                if (instance == null) {
                    instance = new Lock2Singleton();
                }
            }
        }
        return instance;
    }

}
