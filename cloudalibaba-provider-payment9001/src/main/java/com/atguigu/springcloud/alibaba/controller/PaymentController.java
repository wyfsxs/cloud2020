package com.atguigu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/10 18:03
 * @version: v1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value(value = "${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {

        return "nacos register, serverport=" + serverPort + "\t id:" + id;
    }


}
