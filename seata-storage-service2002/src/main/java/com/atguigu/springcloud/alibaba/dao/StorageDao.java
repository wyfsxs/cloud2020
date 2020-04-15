package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/14 15:21
 * @version: v1.0
 */
@Mapper
public interface StorageDao {

    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
