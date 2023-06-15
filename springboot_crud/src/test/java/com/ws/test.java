package com.ws;

import org.junit.jupiter.api.Test;

import java.time.Year;


public class test {

    @Test
    public void test(){

        Year now = Year.now();
        System.out.println(now);

        String s = String.valueOf(now);
        System.out.println(s);

        String s1 = now.toString();
        System.out.println(s1);

    }

}
