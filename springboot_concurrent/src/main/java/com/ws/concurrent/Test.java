package com.ws.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        //lambda表达式 通过继承Thread开启线程1
        Thread threadOne = new Thread(() -> System.out.println("线程1-通过继承Thread类，重写run()方法实现"));

        //lambda表达式 通过实现Runnable接口开启线程2
        Runnable myRunnable = () -> System.out.println("线程2-通过实现Runable接口，实现run()方法开启线程");
        Thread threadTwo = new Thread(myRunnable, "线程2");

        //lambda表达式 通过实现Callable接口开启线程3
        Callable<String> callable = () -> {
            System.out.println("线程3-通过实现Callable接口，实现call()方法实现");
            return "该方法有返回值";
        };
        Thread threadThree = new Thread(new FutureTask<String>(callable));

        threadOne.start();
        threadTwo.start();
        threadThree.start();

    }
}
