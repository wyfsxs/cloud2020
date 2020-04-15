package com.atguigu.springcloud.alibaba.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.entities.CommonResult;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/12 14:48
 * @version: v1.0
 */
public class ClusterBlockHandle {


    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(444, "按客户自定义，global handleException---------1");

    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(444, "按客户自定义，global handleException---------2");

    }
}
