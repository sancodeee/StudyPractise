package com.ws.CreationalDesignPatterns.FactoryPatterns.impl;

import com.ws.CreationalDesignPatterns.FactoryPatterns.product;

public class Computer implements product {

    @Override
    public String product() {
        String computer = "生产一个电脑";
        return computer;
    }

}
