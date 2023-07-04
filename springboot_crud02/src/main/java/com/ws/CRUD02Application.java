package com.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CRUD02Application {
    public static void main(String[] args) {
        SpringApplication.run(CRUD02Application.class, args);
    }
}
