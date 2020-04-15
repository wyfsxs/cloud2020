package com.atguigu.springcloud.alibaba.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @function: 雪花算法实现
 * @author: create by Alfred.Wong
 * @date: 2020/4/15 15:13
 * @version: v1.0
 */
@Component
@Slf4j
public class IdGeneratorSnowflake {

    private long workerId = 0L;
    private long datacenterId = 1L;
    private Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

    @PostConstruct
    public void init() {

        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workerId:{}", workerId);
        } catch (Exception e) {
            log.warn("当前机器的workID获取失败", e);
            workerId = NetUtil.getLocalhostStr().hashCode();
            log.info("当前机器 workId:{}", workerId);
        }

    }


    public synchronized long snowflakeId() {

        return snowflake.nextId();
    }


    public synchronized long snowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }


    public static void main(String[] args) {
        System.out.println(new IdGeneratorSnowflake().snowflakeId());
    }
}
