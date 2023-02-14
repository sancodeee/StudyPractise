package com.ws.service.Impl;

import com.ws.Utils.CodeUtils;
import com.ws.service.SimCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SimCodeServiceImpl implements SimCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Override
//    @Cacheable(value = "telephoneNum" ,key = "#telephoneNum") 该注解 写入缓存 并会读取缓存 ，如果下一次的查询结果在该缓存中，则会直接从缓存里拿值返回回去
    @CachePut(value = "cacheSpace" , key = "#telephoneNum")//该注解 只写入缓存 并不会读取缓存 ，即每次会将值存进缓存 ， 查询时并不读取缓存内容
    public String getCheckCode(String telephoneNum) {
        log.info("根据电话号码：{}",telephoneNum);
        String s = codeUtils.generator(telephoneNum);
        log.info("生成验证码：{}" , s);
        return s;
    }

    @Override
    public boolean check(String telephoneNum, String checkCode) {
        //根据电话号码，从缓存里查询验证码，与传进来的验证码比对
        String s = codeUtils.get(telephoneNum);
        boolean equals = checkCode.equals(s);
        return equals;
    }

}
