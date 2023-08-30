package com.ws.CreationalDesignPatterns.PrototypePattern;

//具体原型类
public class Circle extends Shape{

    //半径
    private int radius;

    public Circle(int x , int y , int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("绘制一个坐标在"+"("+ getX() + "," + getY()+")"+"的半径为：" + radius + "的圆形");
    }
}
