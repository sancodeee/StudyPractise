package com.ws.cGlibDynamicProxy;


public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public Student(){}

    public void wakeup() {
        System.out.println(name + "早晨醒来了");
    }

    public void sleep() {
        System.out.println(name + "晚上睡觉了");
    }


}
