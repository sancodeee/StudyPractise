package com.ws.Utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

//验证码工具类
@Component
@Slf4j
public class CodeUtils {

    private String [] patch = {"000000","00000","0000","000","00","0",""};

    //根据电话号码生成验证码

    public String generator(String telephoneNum){
        int hash = telephoneNum.hashCode();
        int encryption = 20236666;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        String codeStr = code + "" ;
        int len = codeStr.length();
        return patch[len] + codeStr;
    }

    //校验
    //根据key值 从缓存里取值：缓存里有对应的key，则返回相应的值，没有对应的key，则查询数据库之后在缓存中添加，并返回null
    @Cacheable(value = "cacheSpace" , key = "#telephoneNum")
    public String get(String telephoneNum){
        return null;
    }

    @Test
    void test(){
        CodeUtils codeUtils = new CodeUtils();
        String s = codeUtils.generator("19939549136");
        log.info("验证码：" + s);
    }

}
