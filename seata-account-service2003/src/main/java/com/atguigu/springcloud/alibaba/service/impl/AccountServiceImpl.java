package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.AccountDao;
import com.atguigu.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @function:
 * @author: create by Alfred.Wong
 * @date: 2020/4/14 15:50
 * @version: v1.0
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountDao accountDao;

    @Override
    public int decrease(Long userId, BigDecimal money) {
        log.info("------->AccountService中扣减账户余额开始");
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int decrease = accountDao.decrease(userId, money);
        log.info("------->AccountService中扣减账户余额结束");
        return decrease;
    }
}
