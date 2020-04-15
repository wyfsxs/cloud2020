package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.StorageDao;
import com.atguigu.springcloud.alibaba.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/14 15:26
 * @version: v1.0
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    StorageDao storageDao;


    @Override
    public int decrease(Long productId, Integer count) {
        
        return storageDao.decrease(productId, count);
    }
}
