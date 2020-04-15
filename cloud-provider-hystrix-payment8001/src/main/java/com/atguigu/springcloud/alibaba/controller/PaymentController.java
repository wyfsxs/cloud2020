package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/7 10:54
 * @version: v1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {

        String paymentInfo_ok = paymentService.paymentInfo_OK(id);
        log.info("********result: " + paymentInfo_ok);
        return paymentInfo_ok;
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {

        String result = paymentService.paymentInfo_Timeout(id);
        log.info("********result: " + result);
        return result;
    }

    /**
     * 熔断测试
     * localhost:8001/payment/circuit/31
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentCircuitBreak(@PathVariable("id") Integer id) {

        String result = paymentService.paymentCircuitBreak(id);
        log.info("********result: " + result);
        return result;
    }
}
