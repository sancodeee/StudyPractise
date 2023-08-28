package com.ws.concurrent;


import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    @Test
    public void test() {
        //大小为3的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        //线程2
        Runnable myRunnable = () -> System.out.println("线程2-实现Runnable接口 实现run()方法");
        threadPool.execute(myRunnable);

        //线程3
        Callable<String> callable = () -> {
            System.out.println("线程3-通过实现Callable接口，实现call()方法实现");
            return "该方法有返回值";
        };
        //Future封装对象
        Future<String> future = threadPool.submit(callable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }

}
