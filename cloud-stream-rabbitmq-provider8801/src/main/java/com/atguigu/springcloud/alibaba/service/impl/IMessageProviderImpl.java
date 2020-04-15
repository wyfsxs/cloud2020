package com.atguigu.springcloud.alibaba.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.alibaba.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/9 15:32
 * @version: v1.0
 */
@EnableBinding(Source.class) //定义消息的发送管道
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = IdUtil.randomUUID();
        boolean send = output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("**********serial: " + serial);
        return null;
    }
}
