package com.ws;


import com.ws.Enum.Season;

import java.util.Arrays;

public class DemoTest {
    public static void main(String[] args) {

        Season spring = Season.SPRING;
        String s = spring.toString();
        Season[] values = spring.values();
        Season[] values1 = Season.values();
        //获取枚举类对象的序列 spring是春天 在枚举类中是第一个对象 所以序号是 0
        int ordinal = spring.ordinal();
        Season summer = Season.valueOf("SUMMER");
        int ordinal2 = summer.ordinal();

        System.out.println(spring);
        System.out.println(s);
//        for (Season s1 : values) {
//            System.out.println(s1);
//        }
        for (Season s2 : values) {
            System.out.println(s2);
        }
        System.out.println(ordinal);
        System.out.println(ordinal2);
        System.out.println(summer);

        //比较两个对象序号的大小 冬天比夏天多了 2 所以返回值是 2
        System.out.println(Season.WINTER.compareTo(Season.SUMMER));

        System.out.println(Arrays.toString(values1));

    }
}
