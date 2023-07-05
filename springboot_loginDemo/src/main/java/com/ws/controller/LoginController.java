package com.ws.controller;

import com.ws.entity.LoginUserEntity;
import com.ws.service.LoginUserService;
import com.ws.vo.result.ResultResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginUserService loginUserService;

    @GetMapping("/addUser")
    public ResultResp<Boolean> addUser(LoginUserEntity loginUserEntity){
        boolean b = loginUserService.addUserInfo(loginUserEntity);
        return ResultResp.SUCCESS(b);
    }

    @GetMapping("/loginVerifi")
    public ResultResp loginVerifi() {


        return null;
    }

}
