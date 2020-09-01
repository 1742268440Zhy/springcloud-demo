package com.zhyheima.springcloud.controller;

import com.zhyheima.springcloud.entities.CommonResult;
import com.zhyheima.springcloud.entities.Payment;
import com.zhyheima.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

//    服务发现，获取服务信息
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("****插入结果："+result);

        if (result>0) {
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort, result);
        }
        return new CommonResult(444,"插入数据失败",null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("****查询结果："+payment);

        if (payment !=null) {
            return new CommonResult(200,"查询成功,serverPort:"+serverPort, payment);
        }
        return new CommonResult(444,"没有对应记录，查询ID："+id,null);
    }

    /**
      * @ Describe  : 添加服务发现方法，获取某个集群服务中的相关信息
      * @ Author    : 张慧颖
      * @ Date      : 2020/5/25 16:42
      * @param
      * @return     :
     **/
    @GetMapping(value = "/payment/discovery")
    public Object discover(){
//        获取服务列表清单
        List<String> service=discoveryClient.getServices();
        for (String element :
                service) {
            log.info("****element: " + element);
        }
//       根据微服务的具体微服务名称， 获得一个微服务下的全部实例
        List<ServiceInstance> instances=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance :
               instances ) {
            log.info(instance.getServiceId()+"\t" + instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
        public String paymentFeignTimeout(){
            try {
                TimeUnit.SECONDS.sleep(3);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            return serverPort;
        }
}
