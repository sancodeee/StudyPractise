package com.ws;

public class JniDemo01 {

    public static void main(String[] args) {

    }

    // 将需要由c/c++实现的方法用native关键字声明
    public static native int add(int a, int b);

    // 用静态代码块进行动态链接库加载 (win)jnidemo.dll / (linux)jnidemo.so
    // System.loadLibrary("jnidemo") 不需要后缀，只要(库所在路径上加上)库名
    static {
        System.loadLibrary("jnidemo");
    }

}
