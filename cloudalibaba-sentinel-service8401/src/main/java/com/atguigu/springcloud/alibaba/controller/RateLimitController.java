package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.entities.CommonResult;
import com.atguigu.springcloud.alibaba.entities.Payment;
import com.atguigu.springcloud.alibaba.myhandle.ClusterBlockHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/12 14:31
 * @version: v1.0
 */
@RestController
@Slf4j
public class RateLimitController {


    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {

        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));

    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");

    }


    @GetMapping(value = "/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {

        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));

    }


    /**
     * @return
     */

    @GetMapping(value = "/rateLimit/customerBlockHandle")
    @SentinelResource(value = "customerBlockHandle",
            blockHandlerClass = ClusterBlockHandle.class,
            blockHandler = "handleException2")
    public CommonResult customerBlockHandle() {

        return new CommonResult(200, "按客户自定义", new Payment(2020L, "serial003"));

    }
}
