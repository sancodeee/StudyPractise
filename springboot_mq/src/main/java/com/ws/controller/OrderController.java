package com.ws.controller;

import com.ws.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String handleOrder(@RequestParam(name = "id" ,required = true ,defaultValue = "1") String id){

        orderService.order(id);
        return "处理"+id+"号订单";
    }

}
