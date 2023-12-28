package com.ws.CreationalDesignPatterns.SingletonPattern;

/**
 * 双重校验锁实现单例模式
 * 在懒汉模式的基础上进一步优化，给静态对象加上volatile关键字来保证初始化时对象的唯一性
 *
 * @author wangsen_a
 * @date 2023/12/28
 */
public class LockDoubleSingleton {

    /**
     * 实例
     */
    private volatile static LockDoubleSingleton instance;

    private LockDoubleSingleton() {
    }

    /**
     * 对外暴露获取对象实例的方法
     *
     * @return {@link LockDoubleSingleton}
     */
    public static LockDoubleSingleton getSingleton() {
        if (instance == null) {
            //同步代码块 本类的class对象作为锁对象 class对象是由jvm生成的唯一的对象
            synchronized (LockDoubleSingleton.class) {
                if (instance == null) {
                    instance = new LockDoubleSingleton();
                }
            }
        }
        return instance;
    }

}
