package com.zhyheima.springcloud.service.impl;

import com.zhyheima.springcloud.dao.PaymentDao;
import com.zhyheima.springcloud.entities.Payment;
import com.zhyheima.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
