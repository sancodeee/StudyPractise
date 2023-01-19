package com.ws.factoryPatterns.impl;

import com.ws.factoryPatterns.product;

public class Phone implements product {
    @Override
    public void product() {
        System.out.println("生产一个手机");
    }
}
