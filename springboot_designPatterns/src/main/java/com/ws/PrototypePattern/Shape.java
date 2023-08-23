package com.ws.PrototypePattern;

//抽象原型类
public abstract class Shape implements Cloneable {

    //坐标地址
    private int x;
    private int y;

    //抽象的绘制方法
    public abstract void draw();

    //重写 克隆方法
    public Object clone() {
        Object cloneObject = null;
        try {
            //浅拷贝
            cloneObject = super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return cloneObject;
    }

    public Shape(int x , int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
