package com.ws.AbstractFactoryPattern.impl;

import com.ws.AbstractFactoryPattern.product;


public class huaweiCamera implements product {
    @Override
    public String createProduct() {
        String huaweiCamera = "生产一个华为相机";

        return huaweiCamera;
    }
}
