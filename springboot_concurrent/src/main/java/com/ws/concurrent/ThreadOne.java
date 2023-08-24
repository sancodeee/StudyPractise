package com.ws.concurrent;

import lombok.SneakyThrows;
//线程1-通过继承Thread实现线程方法
public class ThreadOne extends Thread{

    @SneakyThrows
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("线程1：继承Thread类，重写run()方法");
        }
        Thread.sleep(1000);

    }


}
