package com.atguigu.springcloud.service;

import com.atguigu.springcloud.alibaba.entities.CommonResult;
import com.baidu.brpc.spring.annotation.RpcExporter;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/15 16:41
 * @version: v1.0
 */
@RpcExporter
public class PaymentServiceImpl implements PaymentService {


    @Override
    public CommonResult getPaymentInfo(Long id) {
        return new CommonResult(200, "测试brpc远程调用框架整合springcloud,id: " + id);
    }
}
