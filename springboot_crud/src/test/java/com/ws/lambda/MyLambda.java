package com.ws.lambda;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.ws.lambda.FunctionalInterface.*;
import com.ws.lambda.FunctionalInterface.Impl.MyFunctionalImpl;
import com.ws.lambda.FunctionalInterface.Impl.MyFunctionalImpl5;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.PrintStream;
import java.util.ArrayList;

@SpringBootTest
public class MyLambda {

    //使用匿名内部类，实现接口中的抽象方法：一个入参 无返回值
    @Test
    public void test01(){

        MyFunctional myFunctional = new MyFunctional() {
            @Override
            public void fun(String say) {
                System.out.println(say);
            }
        };
        myFunctional.fun("一个入参 无返回值");
    }

    //使用lambda表达式 一个入参 无返回值
    /**
     * 参数类型可以省略，左边入参只有一个参数，小括号可以省略，右边方法体只有一条语句，大括号可以省略
     * */
    @Test
    public void test02(){
        MyFunctional myFunctional = say -> System.out.println(say);
        myFunctional.fun("一个入参 无返回值");
    }

    //匿名内部类 ： 无入参 有返回值
    @Test
    public void test03(){
        MyFunctional5 myFunctional5 = new MyFunctional5() {
            @Override
            public String fun() {
                return "无入参 一个返回值";
            }
        };
        String fun = myFunctional5.fun();
        System.out.println(fun);
    }

    //lambda表达式： 无入参 有返回值
    @Test
    public void test04(){
        MyFunctional5 myFunctional5 = () -> "无入参 一个返回值";
        String fun = myFunctional5.fun();
        System.out.println(fun);
    }

    //匿名内部类：无入参 无返回值
    @Test
    public void test05(){
        MyFunctional2 myFunctional2 = new MyFunctional2() {
            @Override
            public void sout() {
                System.out.println("打印：无入参 无返回值");
            }
        };
    }

    //lambda表达式：无入参 无返回值
    @Test
    public void test06(){
        MyFunctional2 myFunctional2 = () -> System.out.println("打印功能：无入参 无返回值");
        myFunctional2.sout();
    }

    //匿名内部类：两个入参 有返回值
    @Test
    public void test07(){

        MyFunctional3 myFunctional3 = new MyFunctional3() {
            @Override
            public int fun(int a, int b) {
                return a + b;
            }
        };
        int fun = myFunctional3.fun(1, 2);
        System.out.println(fun);
    }

    //lambda表达式：两个入参 有返回值
    @Test
    public void test08(){
        MyFunctional3 myFunctional3 = (a, b) -> {
            System.out.println("表达式右侧两行语句 ，不用省略大括号和return");
            return a + b;
        };

    }

    //匿名内部类：两个入参 无返回值
    @Test
    public void test09(){

        MyFunctional4 myFunctional4 = new MyFunctional4() {
            @Override
            public void fun(String a, String b) {
                System.out.println(a + b);
            }
        };
        myFunctional4.fun("两个入参",",无返回值");

    }

    //lambda表达式：两个入参 无返回值
    @Test
    public void test10(){
        MyFunctional4 myFunctional4 = (String a ,String b) -> System.out.println(a+b);
        myFunctional4.fun("两个入参，" ,"无返回值");
    }

    //方法引用：一个入参 无返回值
    @Test
    public void test11(){
        //实现一个MyFunctional接口的实现类 实现通用方法fun()
        //创建MyFunctionalImpl实例
        MyFunctionalImpl myFunctionalImpl = new MyFunctionalImpl();
        //通过实例::方法 引用实现类中的通用方法，去实现MyFunctional接口
        MyFunctional myFunctional = myFunctionalImpl::fun;
        myFunctional.fun("函数式接口");
    }

    //方法引用： 无入参 有返回值
    @Test
    public void test12(){
        MyFunctionalImpl5 myFunctionalImpl5 = new MyFunctionalImpl5();
        MyFunctional5 myFunctional5= myFunctionalImpl5::fun;
        myFunctional5.fun();
    }

    //方法引用
    @Test
    public void test13(){
        ArrayList<String> list = new ArrayList<String>(){
            {
                this.add("zhangsan");
                this.add("lisi");
                this.add("wangwu");
                this.add("laoliu");
            }
        };
        //forEach()方法的入参是Consumer<T>接口 该接口中只有一个抽象方法void accept()
        //可以通过方法引用来实现Consumer<T>这个函数式接口
        //通过System.out可以获取一个PrintStream实例对象 该实例调用println()方法来实现打印功能
        PrintStream out = System.out;
        out.println("good!");
        //所以可以通过System.out::println()的方式实现方法引用
        list.forEach(System.out::println);
    }




}


