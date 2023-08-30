package com.ws.CreationalDesignPatterns.AbstractFactoryPattern.impl;

import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.product;

public class xiaomiPhone implements product {


    @Override
    public String createProduct() {
        String phone = "生产一个小米手机";
        return phone;
    }

}
