package com.atguigu.springcloud.alibaba.service;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/14 15:24
 * @version: v1.0
 */
public interface StorageService {

    int decrease(Long productId,Integer count);
}
