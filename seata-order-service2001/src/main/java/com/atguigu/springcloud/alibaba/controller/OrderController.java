package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.IdGeneratorSnowflake;
import com.atguigu.springcloud.alibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/14 14:24
 * @version: v1.0
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    OrderService orderService;

    @Resource
    IdGeneratorSnowflake idGeneratorSnowflake;

    /**
     * http://10.102.100.1:2001/order/create?userId=1&productId=1&count=10&money=100
     *
     * @param order
     * @return
     */

    @GetMapping(value = "/order/create")
    public CommonResult create(Order order) {

        orderService.create(order);

        return new CommonResult(200, "订单创建成功");

    }


    /**
     * 生成id,通过雪花算法
     *
     * @return
     */
    @GetMapping("snowflake")
    public String getIDBySnowflake() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {
                System.out.println(idGeneratorSnowflake.snowflakeId());
            });
        }
        threadPool.shutdown();
        return "hello snowflake";
    }
}

