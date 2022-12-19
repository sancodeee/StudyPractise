package com.ws.testDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringbootRedisTest {

    /**
     * RedisTemplate以对象作为key和value，内部对数据进行了序列化
     * 通过RedisTemplate对象操作redis，其数据 和 通过客户端操作redis的数据 不同步
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void set(){
        ValueOperations opsForValue = redisTemplate.opsForValue();
        opsForValue.set("name","wangsen");

    }

    @Test
    void get(){
        ValueOperations opsForValue = redisTemplate.opsForValue();
        System.out.println(opsForValue.get("name"));
    }

    @Test
    void putHash(){
        HashOperations opsForHash = redisTemplate.opsForHash();
        opsForHash.put("person1","name","wangsen");
        opsForHash.put("person1","age",21);
        opsForHash.put("person1","type","human");
        opsForHash.put("person2","name","yangjie");
        opsForHash.put("person2","age",22);
        opsForHash.put("person2","type","human");
    }

    @Test
    void getHash(){
        HashOperations opsForHash = redisTemplate.opsForHash();
        Object o1 = opsForHash.get("person1", "name");
        Object o2 = opsForHash.get("person1", "age");
        Object o3 = opsForHash.get("person1", "type");
        Object o4 = opsForHash.get("person2", "name");
        Object o5 = opsForHash.get("person2", "age");
        Object o6 = opsForHash.get("person2", "type");

        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println(o4);
        System.out.println(o5);
        System.out.println(o6);
    }

}
