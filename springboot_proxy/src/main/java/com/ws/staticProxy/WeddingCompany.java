package com.ws.staticProxy;

//代理类
public class WeddingCompany implements Mery{

    //声明一个Mery接口类型的变量；
    private Mery mery;

    //有参构造： 构造方法传参，通过构造防范传递参数给本类中声明的mery对象
    public WeddingCompany(Mery mery){
        this.mery = mery;
    }

    @Override
    public void mery() {
        System.out.println("结婚之前布置现场...");
        mery.mery();
        System.out.println("结婚之后打扫现场...");
    }


}
