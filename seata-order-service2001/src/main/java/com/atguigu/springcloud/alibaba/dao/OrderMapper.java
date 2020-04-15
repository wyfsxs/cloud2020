package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/14 11:54
 * @version: v1.0
 */
@Mapper
public interface OrderMapper {

    // 新建订单
    void create(Order order);

    // 修改订单状态，将 0 改为 1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
