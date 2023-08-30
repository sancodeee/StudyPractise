package com.ws.CreationalDesignPatterns.PrototypePattern;

import java.util.HashMap;
import java.util.Map;

//原型管理器
public class ShapeManager {

    private Map<String, Shape> shapeMap = new HashMap<>();

    //加载形状的方法，并存入map中
    public void loadShapes() {
        Circle circle = new Circle(5, 7, 3);
        shapeMap.put("circle", circle);

        Rectangle rectangle = new Rectangle(4, 7, 3, 2);
        shapeMap.put("rectangle", rectangle);
    }

    //利用克隆 返回不同的对象
    public Shape getShape(String shapeType){
        return (Shape) shapeMap.get(shapeType).clone();
    }

}
