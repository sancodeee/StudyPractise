package com.ws.factoryPatterns;

import com.ws.factoryPatterns.impl.Computer;
import com.ws.factoryPatterns.impl.Phone;
import com.ws.factoryPatterns.impl.Photo;

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
