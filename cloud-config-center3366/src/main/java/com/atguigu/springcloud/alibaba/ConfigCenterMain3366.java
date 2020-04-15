package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/8 22:21
 * @version: v1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigCenterMain3366 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3366.class, args);
    }
}
