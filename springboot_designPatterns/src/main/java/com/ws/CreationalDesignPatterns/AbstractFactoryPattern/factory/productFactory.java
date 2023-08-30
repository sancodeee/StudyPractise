package com.ws.CreationalDesignPatterns.AbstractFactoryPattern.factory;


import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.product;

//工厂接口
public interface productFactory {

    product createPhone();

    product createCamera();

    product createComputer();

}
