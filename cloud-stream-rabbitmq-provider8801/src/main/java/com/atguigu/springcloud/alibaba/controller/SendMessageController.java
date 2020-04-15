package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/9 15:44
 * @version: v1.0
 */
@RestController
@Slf4j
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;


    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return iMessageProvider.send();
    }
}
