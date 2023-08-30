package com.ws.CreationalDesignPatterns.FactoryPatterns.impl;

import com.ws.CreationalDesignPatterns.FactoryPatterns.product;

public class Phone implements product {
    @Override
    public String product() {
        String phone = "生产一个手机";
        return phone;
    }
}
