package com.atguigu.springcloud.alibaba.lb;


import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/6 20:16
 * @version: v1.0
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
