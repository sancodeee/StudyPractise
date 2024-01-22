package com.ws.CreationalDesignPatterns.SingletonPattern;

/**
 * 静态内部类实现单例模式
 * 将对象实例和初始化放在内部类中
 */
public class Singleton {

    /**
     * 静态内部类
     *
     * @author wangsen_a
     * @date 2024/01/22
     */
    public static class SingletonHolder {

        /**
         * 静态内部类实现对象单例原理：<p>
         * 1、懒加载：静态内部类在第一次访问时才会加载，因此实现了懒加载效果。在类加载过程中，并不会立即创建实例。<p>
         * 2、线程安全：jvm保证静态内部类的加载是线程安全的。当多个线程尝试同时访问初始化对象的方法时，由于静态内部类只会加载一次，因此可以保证只有一个实例被创建。<p>
         * 3、高效率：只有在第一次访问创建对象方法时，静态内部类才会被加载，因此避免了在类加载时就创建实例的开销。<p>
         * 4、简洁：通过静态内部类实现单例模式的代码相对简洁，无需使用synchronized关键字等线程同步机制，而且不会有性能上的损耗。
         */
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }


    /**
     * 对外暴露的提供本类对象的唯一接口方法<p>
     * 用final修饰，防止被子类重写
     *
     * @return {@link Singleton}
     */
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
