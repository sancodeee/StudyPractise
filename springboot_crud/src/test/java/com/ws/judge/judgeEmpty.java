package com.ws.judge;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class judgeEmpty {

    //Long类型非空判断
    @Test
    public void testFirst(){

        Long id = Long.valueOf(1);

        if( id != null || id.longValue() != 0){
            log.info("Long类型id不为空");
        }else {
            log.info("Long类型为空");
        }

    }

    //String类型非空判断
    @Test
    public void testSecond(){
        String str = "";

        if (!StringUtils.isBlank(str)){
            log.info("String类型不为空");
        }else{
            log.info("String类型为空");
        }

    }

    @Test
    public void testThird(){
        Integer num = 0;

        if(num != null ){
            log.info("Integer类型不为空");
        }else {
            log.info("Integer类型为空");
        }

    }

    @Test
    public void testFourth(){

        Integer id = 1;
        if(id != null){
            
        }

    }

}
