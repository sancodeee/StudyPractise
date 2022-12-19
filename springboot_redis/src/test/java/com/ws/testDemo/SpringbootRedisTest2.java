package com.ws.testDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class SpringbootRedisTest2 {


    /**
     * 通过StringRedisTemplate对象操作redis 其数据和客户端是同步的
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void get(){

        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        String s = opsForValue.get("name");
        System.out.println(s);

    }

}
