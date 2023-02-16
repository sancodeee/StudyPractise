package com.ws.service.Impl;

import com.ws.service.ProcessMessage;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProcessMessageImpl implements ProcessMessage {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    //发送消息 生产消息
    @Override
    public void sendMessage(String id) {
        System.out.println("发送短信"+id+"号订单已纳入发送队列...");
        jmsMessagingTemplate.convertAndSend(id);
    }

    //处理消息
    @Override
    public String handleMessage() {
        String id = jmsMessagingTemplate.receiveAndConvert(String.class);
        System.out.println(id+"号短信发送完成...");
        return id;
    }
}
