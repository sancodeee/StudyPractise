package com.ws.CreationalDesignPatterns.SingletonPattern;

/**
 * 懒汉模式(线程安全)
 * 先定义对象，调取方法后才创建对象实例
 */
public class LazySingleton {

    //静态变量在类加载时就已经被创建并赋予初始值了
    private static LazySingleton instance;

    private LazySingleton() {
    }


    /**
     * 对外暴露创建实例的唯一接口方法
     *
     * @return {@link LazySingleton}
     */
    public static synchronized LazySingleton getInstance() {
        // 实例为null时才进行创建，否则直接返回，从而保证了单例
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
