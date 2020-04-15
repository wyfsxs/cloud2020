package com.atguigu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/6 12:54
 * @version: v1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentZK() {

        return "StringCloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
