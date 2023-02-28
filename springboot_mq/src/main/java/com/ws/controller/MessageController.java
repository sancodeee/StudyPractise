package com.ws.controller;

import com.ws.service.ProcessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private ProcessMessage processMessage;

    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam(name = "id" , required = true ,defaultValue = "1") String id){
        processMessage.sendMessage(id);
        return id;
    }

    @GetMapping("/handleMessage")
    public String handleMessage(){
        return processMessage.handleMessage();
    }



}
