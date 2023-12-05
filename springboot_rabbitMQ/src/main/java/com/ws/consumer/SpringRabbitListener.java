package com.ws.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者测试类
 */
@Component
public class SpringRabbitListener {

    /**
     * 消费者监听队列的方法
     *
     * @param msg 从队列中获取的消息
     */
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage(String msg) {
        System.out.println("消费者1接收到的消息：" + msg);
    }

    /**
     * 消费者监听队列方法2
     *
     * @param msg
     */
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage2(String msg) {
        System.out.println("消费者2接收到的消息" + msg);
    }


}
