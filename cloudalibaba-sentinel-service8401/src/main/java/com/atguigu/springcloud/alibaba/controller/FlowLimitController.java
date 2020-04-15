package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/11 19:23
 * @version: v1.0
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------------- testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {

        return "------------- testB";
    }


    @GetMapping(value = "/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "------------- testD";
    }

    @GetMapping(value = "/testE")
    public String testE() {
        int a = 10 / 0;
        log.info("testE 测试异常比例");
        return "------------- testE";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {

        return "----------testHotKey";
    }


    public String deal_testHotKey(String p1, String p2, BlockException exception) {

        return "-----------------deal_testHotKey,(꒦_꒦) ";

    }
}
