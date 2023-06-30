package com.ws.service.Impl;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JedisServiceImpl {

    public static void main(String[] args) {

        //连接本地redis
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379, 2000);
        Jedis jedis = jedisPool.getResource();

        log.info("---------连接成功！----------");
        log.info("查看服务是否运行：{}", jedis.ping());

        jedis.set("name", "zhangsan");
        log.info("查找：name:{}", jedis.get("name"));

        List<String> nameList = new ArrayList<>();
        nameList.add("zhangsan");
        nameList.add("lisi");
        nameList.add("wangwu");

        nameList.forEach(
                name -> {
                    jedis.lpush("nameList", name);
                }
        );

        List<String> nameList1 = jedis.lrange("nameList", 0, nameList.size());
        log.info("{}", nameList1);

        //归还给连接池
        jedis.close();

    }

}
