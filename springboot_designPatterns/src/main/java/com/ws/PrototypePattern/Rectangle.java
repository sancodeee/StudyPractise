package com.ws.PrototypePattern;

//具体原型类
public class Rectangle extends Shape{

    private int length;
    private int width;

    public Rectangle(int x, int y, int length, int width) {
        super(x, y);
        this.length = length;
        this.width = length;
    }

    @Override
    public void draw() {
        System.out.println("绘制一个坐标在"+"("+ getX() + "," + getY()+")" + "的长方形，其中长为："+ length + "宽为："+ width);
    }
}
