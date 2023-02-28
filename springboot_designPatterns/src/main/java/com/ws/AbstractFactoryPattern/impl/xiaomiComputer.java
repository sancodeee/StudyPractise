package com.ws.AbstractFactoryPattern.impl;

import com.ws.AbstractFactoryPattern.product;

public class xiaomiComputer implements product {
    @Override
    public String createProduct() {

        String computer = "生产一个小米电脑";
        return computer;

    }
}
