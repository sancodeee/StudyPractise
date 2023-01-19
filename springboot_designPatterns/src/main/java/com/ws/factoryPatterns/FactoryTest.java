package com.ws.factoryPatterns;


import com.ws.factoryPatterns.impl.Computer;
import com.ws.factoryPatterns.impl.Phone;
import com.ws.factoryPatterns.impl.Photo;
import org.junit.jupiter.api.Test;

//测试工厂类
public class FactoryTest {

    Factory factory = new Factory();

    @Test
    public void test1(){
        //使用工厂类生产对象
        Computer computer = factory.getComputer();
        Phone phone = factory.getPhone();
        Photo photo = factory.getPhoto();
        computer.product();
        phone.product();
        photo.product();
    }

}
