package com.ws.AbstractFactoryPattern;

import com.ws.AbstractFactoryPattern.factory.impl.huaweiProductFactory;
import com.ws.AbstractFactoryPattern.factory.impl.xiaomiProductFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//抽象工厂模式
@Slf4j
public class AbstractFactoryTest {

    @Test
    void test01(){

        huaweiProductFactory h = new huaweiProductFactory();

        xiaomiProductFactory x = new xiaomiProductFactory();

        product hComputer = h.createComputer();
        log.info("华为产品：" + hComputer.createProduct());
        product hCamera = h.createCamera();
        log.info("华为产品：" + hCamera.createProduct());
        product hPhone = h.createPhone();
        log.info("华为产品：" + hPhone.createProduct());

        product xCamera = x.createCamera();
        log.info("小米产品：" + xCamera.createProduct());
        product xComputer = x.createComputer();
        log.info("小米产品：" + xComputer.createProduct());
        product xPhone = x.createPhone();
        log.info("小米产品：" + xPhone.createProduct());




    }

}
