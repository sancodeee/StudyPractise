package com.ws.CreationalDesignPatterns.AbstractFactoryPattern.factory.impl;

import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.factory.productFactory;
import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.impl.huaweiCamera;
import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.impl.huaweiComputer;
import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.impl.huaweiPhone;
import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.product;

//实现类：华为工厂-生产华为产品
public class huaweiProductFactory implements productFactory {
    @Override
    public product createPhone() {
        huaweiPhone huaweiPhone = new huaweiPhone();
        return huaweiPhone;
    }

    @Override
    public product createCamera() {
        huaweiCamera huaweiCamera = new huaweiCamera();
        return huaweiCamera;
    }

    @Override
    public product createComputer() {
        huaweiComputer huaweiComputer = new huaweiComputer();
        return huaweiComputer;
    }
}
