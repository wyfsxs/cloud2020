package com.atguigu.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/14 15:49
 * @version: v1.0
 */
public interface AccountService {

    int decrease(Long userId, BigDecimal money);
}
