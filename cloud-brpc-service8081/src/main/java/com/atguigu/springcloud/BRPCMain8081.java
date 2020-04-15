package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/15 16:36
 * @version: v1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BRPCMain8081 {

    public static void main(String[] args) {
        SpringApplication.run(BRPCMain8081.class, args);
    }
}
