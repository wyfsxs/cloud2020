package com.atguigu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/9 16:14
 * @version: v1.0
 */
@Component
@Slf4j
@EnableBinding(Sink.class)
public class ReceiveMessageListener {

    @Value(value = "${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者2号，-----------> 接收到的消息是: " + message.getPayload() + "\t serverPort: " + serverPort);
    }
}
