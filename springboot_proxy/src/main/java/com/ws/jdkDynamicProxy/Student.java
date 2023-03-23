package com.ws.jdkDynamicProxy;

public class Student implements Person {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void wakeup() {
        System.out.println(name + "早晨醒来了");
    }

    @Override
    public void sleep() {
        System.out.println(name + "晚上睡觉了");
    }
}
