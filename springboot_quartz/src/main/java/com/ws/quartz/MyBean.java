package com.ws.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Scheduled(cron = "0/1 * * * * ?")
    public void print(){
        System.out.println(Thread.currentThread().getName()+"springboot自带定时任务功能task...");
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void printTwo(){
        System.out.println(Thread.currentThread().getName()+"springboot自带定时任务功能task2");
    }

}
