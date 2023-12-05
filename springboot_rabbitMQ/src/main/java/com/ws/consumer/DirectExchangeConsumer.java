package com.ws.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectExchangeConsumer {

    /**
     * 消费者1
     *
     * @param msg 接收到的消息
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "it.direct", type = ExchangeTypes.DIRECT),
            key = {"one", "two"}
    ))
    public void listenDirectQueue1(String msg) {
        System.out.println(msg);
    }

    /**
     * 消费者2
     *
     * @param msg 接收到的消息信息
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "it.direct", type = ExchangeTypes.DIRECT),
            key = {"two", "three"}
    ))
    public void listenDirectQueue2(String msg) {
        System.out.println(msg);
    }

}
