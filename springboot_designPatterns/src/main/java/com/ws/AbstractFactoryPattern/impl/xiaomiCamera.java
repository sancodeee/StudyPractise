package com.ws.AbstractFactoryPattern.impl;

import com.ws.AbstractFactoryPattern.product;

//产品实现类
public class xiaomiCamera implements product {
    @Override
    public String createProduct() {

        String camera = "生产一个小米相机";
        return camera;

    }
}
