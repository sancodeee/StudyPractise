package com.ws.lambda.FunctionalInterface.Impl;

import com.ws.lambda.FunctionalInterface.MyFunctional;

public class MyFunctionalImpl implements MyFunctional {

    //一个参数 无返回值
    @Override
    public void fun(String say) {
        System.out.println(say);
    }
}
