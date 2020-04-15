package com.atguigu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/14 14:31
 * @version: v1.0
 */
@Configuration
@MapperScan(value = "com.atguigu.springcloud.alibaba.dao")
public class MybatisConfig {
}
