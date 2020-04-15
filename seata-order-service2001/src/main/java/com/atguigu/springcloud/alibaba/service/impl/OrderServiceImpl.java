package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderMapper;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/14 12:46
 * @version: v1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;
    @Resource
    AccountService accountService;
    @Resource
    StorageService storageService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说:
     * 下订单->减库存->减余额->改状态
     * GlobalTransactional seata开启分布式事务,异常时回滚,name保证唯一即可
     *
     * @param order 订单对象
     */
    @Override
    @GlobalTransactional(name = "fsp_tx_group",rollbackFor = Exception.class)
    public void create(Order order) {

        // 1.新建订单
        log.info("---------> 开始创建订单");
        orderMapper.create(order);

        // 2.扣减库存
        log.info("---------> 订单微服务开始调用库存，作扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("---------> 订单微服务开始调用库存，作扣减end");

        // 3.扣减账户
        log.info("---------> 订单微服务开始调用账户，作扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("---------> 订单微服务开始调用账户，作扣减end");

        // 4.修改订单的状态
        log.info("---------> 修改订单状态开始");
        orderMapper.update(order.getUserId(), 0);
        log.info("---------> 修改订单状态end");

        log.info("下订单结束了，~~~O(∩_∩)O哈哈~");
    }
}
