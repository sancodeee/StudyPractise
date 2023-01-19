package com.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SIMApplication {

    public static void main(String[] args) {

        SpringApplication.run(SIMApplication.class,args);
        System.out.println(args);
    }

}
