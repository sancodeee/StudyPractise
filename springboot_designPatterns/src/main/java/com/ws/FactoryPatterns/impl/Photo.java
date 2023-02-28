package com.ws.FactoryPatterns.impl;

import com.ws.FactoryPatterns.product;

public class Photo implements product {
    @Override
    public String product() {
        String photo = "生产一个相机";
        return photo;
    }
}
