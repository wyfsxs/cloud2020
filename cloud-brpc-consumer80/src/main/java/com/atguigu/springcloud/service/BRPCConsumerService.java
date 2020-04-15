package com.atguigu.springcloud.service;

import com.atguigu.springcloud.alibaba.entities.CommonResult;
import com.baidu.brpc.protocol.BrpcMeta;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/15 17:07
 * @version: v1.0
 */
public interface BRPCConsumerService {

    @BrpcMeta(serviceName = "service.BRPCConsumerService", methodName = "getPaymentInfo")
    CommonResult getPaymentInfo(Long id);
}
