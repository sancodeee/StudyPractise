package com.ws.CreationalDesignPatterns.PrototypePattern;

import org.junit.jupiter.api.Test;

//测试
public class Main {

    @Test
    public void test(){
        ShapeManager shapeManager = new ShapeManager();
        //加载对象
        shapeManager.loadShapes();

        //获得对象
        Shape circle = shapeManager.getShape("circle");
        circle.draw();

        Shape rectangle = shapeManager.getShape("rectangle");
        rectangle.draw();


    }

}
