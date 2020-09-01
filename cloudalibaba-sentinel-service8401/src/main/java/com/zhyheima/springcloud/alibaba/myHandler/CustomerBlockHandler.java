package com.zhyheima.springcloud.alibaba.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhyheima.springcloud.entities.CommonResult;

/**
 * @Classname CustomerBlockHandler
 * @Description TODO
 * @Date 2020/3/18 14:57
 * @Created by HuZP
 */
public class CustomerBlockHandler
{
    public static CommonResult handlerException(BlockException exception)
    {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }
    public static CommonResult handlerException2(BlockException exception)
    {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }
}

