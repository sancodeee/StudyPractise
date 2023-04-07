package com.ws.service.Impl;

import com.ws.service.ProcessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProcessMessageImpl implements ProcessMessage {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    //生产者：发送短信业务 将该业务到发送到发送队列中去
    @Override
    public void sendMessage(String id) {
        System.out.println("生产者发送短信业务："+id+"号订单发送到activemq消息队列...");
        jmsMessagingTemplate.convertAndSend(id);
    }

    //消费者：消费消息 从发送队列中拿取发送短信业务，进行消费
    @Override
    public String handleMessage() {
        String id = jmsMessagingTemplate.receiveAndConvert(String.class);
        System.out.println("消费者"+id+"号短信从activemq消息队列中拿取...");
        return id;
    }


}
