package com.ws.service.Impl;

import com.ws.service.OrderService;
import com.ws.service.ProcessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProcessMessage processMessage;

    @Override
    public void order(String id) {
        System.out.println(id+"号订单处理开始...");
        //发送短信业务
        processMessage.sendMessage(id);
        System.out.println(id+"号订单处理完成...");
    }
}
