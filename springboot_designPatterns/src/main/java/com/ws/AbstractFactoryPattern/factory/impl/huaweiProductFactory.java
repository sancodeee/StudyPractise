package com.ws.AbstractFactoryPattern.factory.impl;

import com.ws.AbstractFactoryPattern.factory.productFactory;
import com.ws.AbstractFactoryPattern.impl.huaweiCamera;
import com.ws.AbstractFactoryPattern.impl.huaweiComputer;
import com.ws.AbstractFactoryPattern.impl.huaweiPhone;
import com.ws.AbstractFactoryPattern.product;

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
