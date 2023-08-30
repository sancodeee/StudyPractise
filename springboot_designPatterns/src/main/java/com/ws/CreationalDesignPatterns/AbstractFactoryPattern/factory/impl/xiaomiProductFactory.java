package com.ws.CreationalDesignPatterns.AbstractFactoryPattern.factory.impl;

import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.factory.productFactory;
import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.impl.xiaomiCamera;
import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.impl.xiaomiComputer;
import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.impl.xiaomiPhone;
import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.product;

//实现类：小米工厂-生产小米产品
public class xiaomiProductFactory implements productFactory {
    @Override
    public product createPhone() {
        xiaomiPhone xiaomiPhone = new xiaomiPhone();
        return xiaomiPhone;
    }

    @Override
    public product createCamera() {
        xiaomiCamera xiaomiCamera = new xiaomiCamera();
        return xiaomiCamera;
    }

    @Override
    public product createComputer() {
        xiaomiComputer xiaomiComputer = new xiaomiComputer();
        return xiaomiComputer;
    }
}
