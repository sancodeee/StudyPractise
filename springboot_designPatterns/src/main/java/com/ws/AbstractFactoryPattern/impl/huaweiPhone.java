package com.ws.AbstractFactoryPattern.impl;

import com.ws.AbstractFactoryPattern.product;

public class huaweiPhone implements product {
    @Override
    public String createProduct() {

        String huaweiPhone = "生产一个华为手机";
        return huaweiPhone;
    }
}
