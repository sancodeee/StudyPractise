package com.ws.AbstractFactoryPattern.factory.impl;

import com.ws.AbstractFactoryPattern.factory.productFactory;
import com.ws.AbstractFactoryPattern.impl.xiaomiCamera;
import com.ws.AbstractFactoryPattern.impl.xiaomiComputer;
import com.ws.AbstractFactoryPattern.impl.xiaomiPhone;
import com.ws.AbstractFactoryPattern.product;

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
