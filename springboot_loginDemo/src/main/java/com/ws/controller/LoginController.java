package com.ws.controller;

import com.ws.vo.result.ResultResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @GetMapping("/loginVerifi")
    public ResultResp loginVerifi() {


        return null;
    }

}
