package com.ws.CreationalDesignPatterns.FactoryPatterns.impl;

import com.ws.CreationalDesignPatterns.FactoryPatterns.product;

public class Photo implements product {
    @Override
    public String product() {
        String photo = "生产一个相机";
        return photo;
    }
}
