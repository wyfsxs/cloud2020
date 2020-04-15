package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/6 9:53
 * @version: v1.0
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zk")
    public String paymentZK() {

        return "StringCloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
