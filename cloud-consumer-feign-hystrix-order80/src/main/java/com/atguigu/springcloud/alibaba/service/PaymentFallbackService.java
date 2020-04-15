package com.atguigu.springcloud.alibaba.service;

import org.springframework.stereotype.Component;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/7 14:30
 * @version: v1.0
 */
@Component
public class PaymentFallbackService implements PaymentFeignHystrixService {


    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------PaymentFallbackService fall back-paymentInfo_OK,(꒦_꒦) o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "---------PaymentFallbackService fall back-paymentInfo_Timeout,(꒦_꒦) o(╥﹏╥)o";
    }
}
