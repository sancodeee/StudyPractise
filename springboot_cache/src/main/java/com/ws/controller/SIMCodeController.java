package com.ws.controller;

import com.ws.pojo.SIMCode;
import com.ws.service.SimCodeService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "simCode")
@Slf4j
public class SIMCodeController {

    @Autowired
    private SimCodeService simCodeService;

    //根据电话号码 返回验证码
    @GetMapping(value = "/getCode")
    public String getCode(@RequestParam(value = "telephoneNum" , required = true) String telephoneNum){
        String checkCode = simCodeService.getCheckCode(telephoneNum);
        log.info("控制层得到验证码：" + checkCode);
        return checkCode;
    }

    //验证码校验：根据前端传来的验证码，校验与缓存中的验证码是否一致
    @PostMapping(value = "/checkCode")
    public boolean check(@RequestBody SIMCode simCode){
        log.info("前端传来的电话号码：{}",simCode.getTelephoneNum());
        log.info("前端传来的验证码：{}",simCode.getCheckCode());
        boolean check = simCodeService.check( simCode.getTelephoneNum(), simCode.getCheckCode());
        log.info("是否存在缓存：" + check);
        return check;

    }

}
