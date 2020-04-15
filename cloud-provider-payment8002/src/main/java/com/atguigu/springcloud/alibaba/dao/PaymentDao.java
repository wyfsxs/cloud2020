package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/5 14:29
 * @version: v1.0
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
