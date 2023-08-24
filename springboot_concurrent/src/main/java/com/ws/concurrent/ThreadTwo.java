package com.ws.concurrent;

import lombok.SneakyThrows;

import static java.lang.Thread.sleep;

//通过实现Runnable接口实现线程方法
public class ThreadTwo implements Runnable{

    @SneakyThrows
    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println("线程2：实现Runanble接口，实现run()方法");
        }

        sleep(1500);
    }
}
