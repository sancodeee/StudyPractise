package com.ws.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//生产日志对象的类 通过构造方法传参进行变量的初始化
public class LogFactory {

    private final Class thatClass;
    public static Logger log;

    public LogFactory(){
        thatClass = this.getClass();
        log = LoggerFactory.getLogger(thatClass);
    }

}
