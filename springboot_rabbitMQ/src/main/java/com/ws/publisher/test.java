package com.ws.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class test {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    /**
     * 基础队列
     */
    public void testSimpleQueue() {
        // 队列名称
        String queueName = "simple.queue";
        // 消息内容
        String message = "hello,spring amqp";
        // 指定队列名称和消息
        rabbitTemplate.convertAndSend(queueName, message);
    }


    /**
     * DirectExchange模式生产者
     */
    public void testDirectExchange() {
        // 交换机名称
        String exchangeName = "it.direct";
        // 消息内容
        String message = "这是一条directExchange模式下的消息";
        // routingKey
        String routingKey = "two";
        // 根据routingKey去判断消息发给哪个队列
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }

    /**
     * topicExchange模式生产者。
     * 与directExchange不同的是，routingKey必须是多个单词的列表，并且以 . 分隔
     */
    public void testTopicExchange() {
        // 交换机名称
        String exchangeName = "it.topic";
        // 消息内容
        String message = "这是一条topicExchange模式下的消息";
        //routingKey
        String routingKey = "china.news";
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }


}
