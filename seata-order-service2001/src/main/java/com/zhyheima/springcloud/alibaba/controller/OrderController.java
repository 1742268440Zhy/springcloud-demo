package com.zhyheima.springcloud.alibaba.controller;

import com.zhyheima.springcloud.alibaba.domain.CommonResult;
import com.zhyheima.springcloud.alibaba.domain.Order;
import com.zhyheima.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
