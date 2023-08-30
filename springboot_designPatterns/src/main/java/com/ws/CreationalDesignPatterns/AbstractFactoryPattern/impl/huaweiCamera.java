package com.ws.CreationalDesignPatterns.AbstractFactoryPattern.impl;

import com.ws.CreationalDesignPatterns.AbstractFactoryPattern.product;


public class huaweiCamera implements product {
    @Override
    public String createProduct() {
        String huaweiCamera = "生产一个华为相机";

        return huaweiCamera;
    }
}
