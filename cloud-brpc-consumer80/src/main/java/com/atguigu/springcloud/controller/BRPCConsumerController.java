package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.alibaba.entities.CommonResult;
import com.atguigu.springcloud.service.BRPCConsumerService;
import com.baidu.brpc.spring.annotation.RpcProxy;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/15 17:06
 * @version: v1.0
 */
@RestController
@Slf4j
@Getter
@Setter
public class BRPCConsumerController {

    @RpcProxy(name = "brpc-payment-server")
    BRPCConsumerService brpcConsumerService;


    @GetMapping(value = "/consumer/paymentInfo/{id}")
    public CommonResult getPaymentInfo(@PathVariable("id") Long id) {

        return brpcConsumerService.getPaymentInfo(id);
    }


}
