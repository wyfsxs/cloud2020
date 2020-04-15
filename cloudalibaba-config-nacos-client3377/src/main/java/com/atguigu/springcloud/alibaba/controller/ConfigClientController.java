package com.atguigu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/11 9:58
 * @version: v1.0
 */
@RestController
@Slf4j
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/configInfo")
    public String getConfigInfo() {

        return "serverPort: " + serverPort + "\t\n\n configInfo" + configInfo;
    }
}
