package com.zhyheima.springcloud.alibaba.service;

import com.zhyheima.springcloud.entities.CommonResult;
import com.zhyheima.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Classname PaymentFallbackService
 * @Description TODO
 * @Date 2020/3/19 16:56
 * @Created by HuZP
 */
@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}