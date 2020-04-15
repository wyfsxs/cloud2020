package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.alibaba.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/15 16:38
 * @version: v1.0
 */
@RestController
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @GetMapping(value = "/paymentInfo/{id}")
    public CommonResult getPaymentInfo(@PathVariable("id") Long id) {

        return paymentService.getPaymentInfo(id);
    }


}
