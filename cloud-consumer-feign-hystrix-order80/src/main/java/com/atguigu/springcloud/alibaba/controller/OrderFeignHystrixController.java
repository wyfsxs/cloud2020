package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.service.PaymentFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/7 12:27
 * @version: v1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Globe_FallBackMethod")
public class OrderFeignHystrixController {

    @Resource
    private PaymentFeignHystrixService paymentFeignHystrixService;


    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {

        String result = paymentFeignHystrixService.paymentInfo_OK(id);

        return result;
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {

        int a = 10 / 0;
        String result = paymentFeignHystrixService.paymentInfo_Timeout(id);

        return result;

    }


    public String paymentInfo_TimeoutHandler(Integer id) {

        return "我是消费者80，对方支付系统繁忙请10s钟后再试或者请自己运行出错检查自己，(꒦_꒦) ";
    }


    public String payment_Globe_FallBackMethod() {
        return "Globe异常处理信息，请稍后再试。(*^▽^*)";
    }
}
