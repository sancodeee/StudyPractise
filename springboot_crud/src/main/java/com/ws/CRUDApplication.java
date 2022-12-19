package com.ws;

import com.ws.config.MPConfig;
import com.ws.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class CRUDApplication {
    public static void main(String[] args) {
        //打印args,args是临时配置信息
        System.out.println(Arrays.toString(args));

        ConfigurableApplicationContext ctx = SpringApplication.run(CRUDApplication.class, args);
        ServerConfig serverConfigBean = ctx.getBean(ServerConfig.class);
        System.out.println(serverConfigBean);

        MPConfig mpConfigBean = ctx.getBean(MPConfig.class);
        System.out.println(mpConfigBean);
    }
}
