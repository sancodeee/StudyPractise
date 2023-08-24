package com.ws.concurrent;

import java.util.concurrent.Callable;

//线程3-通过实现Callable接口实现线程方法
public class ThreadThree implements Callable {


    @Override
    public String call() throws Exception {
        return "线程3：实现Callable接口，实现call()方法，call()方法可以有返回值";
    }
}
