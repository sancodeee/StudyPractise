package com.ws.CreationalDesignPatterns.FactoryPatterns.factory;

import com.ws.CreationalDesignPatterns.FactoryPatterns.impl.Computer;
import com.ws.CreationalDesignPatterns.FactoryPatterns.impl.Phone;
import com.ws.CreationalDesignPatterns.FactoryPatterns.impl.Photo;

//工厂类 生产各种对象
public class Factory {

    public Phone getPhone(){
        return new Phone();
    }

    public Photo getPhoto(){
        return new Photo();
    }

    public Computer getComputer(){
        return new Computer();
    }

}
