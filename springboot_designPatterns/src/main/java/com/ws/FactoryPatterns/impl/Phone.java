package com.ws.FactoryPatterns.impl;

import com.ws.FactoryPatterns.product;

public class Phone implements product {
    @Override
    public String product() {
        String phone = "生产一个手机";
        return phone;
    }
}
