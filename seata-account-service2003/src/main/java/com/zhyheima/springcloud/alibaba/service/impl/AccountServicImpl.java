package com.zhyheima.springcloud.alibaba.service.impl;

import com.zhyheima.springcloud.alibaba.dao.AccountDao;
import com.zhyheima.springcloud.alibaba.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;


@Service
public class AccountServicImpl implements AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServicImpl.class);


    @Resource
    AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        //暂时几秒进程
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        accountDao.decrease(userId,money);
        LOGGER.info("------->account-service中扣减账户余额结束");
    }
}
