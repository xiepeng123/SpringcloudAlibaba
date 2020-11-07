package com.xp.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: PaymentMain8001
 * @description: PaymentMain8001主启动类
 * @author: XZQ
 * @create: 2020/3/5 17:30
 **/
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
