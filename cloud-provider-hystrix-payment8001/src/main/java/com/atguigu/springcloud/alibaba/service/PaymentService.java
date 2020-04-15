package com.atguigu.springcloud.alibaba.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/7 10:46
 * @version: v1.0
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {

        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK,id: " + id + "\t" + "O(∩_∩)O哈哈~";
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout(Integer id) {

//        int a= 10/0;
        int TimeNumber = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(TimeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_Timeout,id: " + id + "\t" + "O(∩_∩)O呵呵~ 耗时" + TimeNumber + "ms";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {

        return "线程池：" + Thread.currentThread().getName() + " 系统繁忙或运行报，请稍后再试!!!!,id: " + id + "\t" + "o(*￣︶￣*)o";
    }

    // =======服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreak_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期/时间范文
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率达到多少后跳闸

    })
    public String paymentCircuitBreak(@PathVariable("id") Integer id) {

        if (id < 0) {
            throw new RuntimeException("****** id 不能为负数");
        }

        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;

    }

    public String paymentCircuitBreak_fallback(@PathVariable("id") Integer id) {

        return "ID 不能为负数，请稍后再试，o(╥﹏╥)o id: " + id;
    }
}
