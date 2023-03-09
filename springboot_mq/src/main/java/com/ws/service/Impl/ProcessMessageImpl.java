package com.ws.service.Impl;

import com.ws.service.ProcessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProcessMessageImpl implements ProcessMessage {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    //发送短信业务 将该业务到发送到发送队列中去
    @Override
    public void sendMessage(String id) {
        System.out.println("发送短信业务："+id+"号订单已纳入发送队列...");
        jmsMessagingTemplate.convertAndSend(id);
    }

    //消费消息 从发送队列中拿取发送短信业务，进行消费
    @Override
    public String handleMessage() {
        String id = jmsMessagingTemplate.receiveAndConvert(String.class);
        System.out.println(id+"号短信发送完成...");
        return id;
    }


}
