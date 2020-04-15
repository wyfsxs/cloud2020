package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.entities.CommonResult;
import com.atguigu.springcloud.alibaba.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/12 15:22
 * @version: v1.0
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444, "fallback", new Payment(id, "errorSerial"));
    }
}