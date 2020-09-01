package com.zhyheima.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8008 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8008.class,args);
    }
}
