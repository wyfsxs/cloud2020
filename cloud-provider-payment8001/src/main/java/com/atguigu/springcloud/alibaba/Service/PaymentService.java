package com.atguigu.springcloud.alibaba.Service;

import com.atguigu.springcloud.alibaba.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/5 14:44
 * @version: v1.0
 */

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
