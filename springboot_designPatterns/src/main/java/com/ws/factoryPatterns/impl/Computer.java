package com.ws.factoryPatterns.impl;

import com.ws.factoryPatterns.product;

public class Computer implements product {

    @Override
    public void product() {
        System.out.println("生产一个电脑");
    }
}
