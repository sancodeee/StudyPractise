package com.ws.FactoryPatterns;

import com.ws.FactoryPatterns.factory.Factory;
import com.ws.FactoryPatterns.impl.Computer;
import com.ws.FactoryPatterns.impl.Phone;
import com.ws.FactoryPatterns.impl.Photo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//工厂模式
@Slf4j
public class FactoryTest {

    Factory factory = new Factory();

    @Test
    public void test1(){
        //使用工厂类生产不同的对象
        Computer computer = factory.getComputer();
        Phone phone = factory.getPhone();
        Photo photo = factory.getPhoto();
        String c = computer.product();
        log.info(c);
        String p = phone.product();
        log.info(p);
        String p2 = photo.product();
        log.info(p2);
    }

    @Test
    void test2(){
        String str = "abcdefg";
        String substring = str.substring(0, 3);
        log.info(substring);
    }

}
