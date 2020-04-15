package com.atguigu.springcloud.service;

import com.atguigu.springcloud.alibaba.entities.CommonResult;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/15 16:42
 * @version: v1.0
 */
public interface PaymentService {
    CommonResult getPaymentInfo(Long var1);
}
