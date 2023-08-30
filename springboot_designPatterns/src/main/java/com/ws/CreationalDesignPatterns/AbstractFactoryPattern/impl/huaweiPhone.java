package com.ws.CreationalDesignPatterns.AbstractFactoryPattern.impl;

import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.product;

public class huaweiPhone implements product {
    @Override
    public String createProduct() {

        String huaweiPhone = "生产一个华为手机";
        return huaweiPhone;
    }
}
