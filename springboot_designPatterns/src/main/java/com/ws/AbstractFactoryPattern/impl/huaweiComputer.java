package com.ws.AbstractFactoryPattern.impl;

import com.ws.AbstractFactoryPattern.product;

public class huaweiComputer implements product {
    @Override
    public String createProduct() {

        String huaweiComputer = "生产一个华为电脑";
        return huaweiComputer;
    }
}
