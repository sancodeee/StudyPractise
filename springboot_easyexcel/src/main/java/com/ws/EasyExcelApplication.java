package com.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ws.mapper")
public class EasyExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyExcelApplication.class,args);
    }

}
