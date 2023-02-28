package com.ws.AbstractFactoryPattern.factory;


import com.ws.AbstractFactoryPattern.product;

//工厂接口
public interface productFactory {

    product createPhone();

    product createCamera();

    product createComputer();

}
