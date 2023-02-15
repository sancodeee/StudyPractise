package com.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling //开启spring自带定时任务
public class QuartzApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class,args);
    }
}
