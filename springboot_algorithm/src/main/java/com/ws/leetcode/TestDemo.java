package com.ws.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 测试演示
 * 测试
 *
 * @author wangsen_a
 * @date 2024/01/22
 */
public class TestDemo {

    @Test
    public void test() {
        HashMap<String, String> map = new HashMap<>(16, 0.75f);

        map.put("1", "yi");
        map.put("3", "san");
        map.put("2", "er");
        System.out.println("遍历hashmap：");
        map.forEach((k, v) -> {
            System.out.println(k + "-" + v);
        });

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("1", "yi");
        linkedHashMap.put("3", "san");
        linkedHashMap.put("2", "er");
        System.out.println("遍历linkedhashmap：");
        linkedHashMap.forEach((k, v) -> {
            System.out.println(k + "-" + v);
        });

    }

}
