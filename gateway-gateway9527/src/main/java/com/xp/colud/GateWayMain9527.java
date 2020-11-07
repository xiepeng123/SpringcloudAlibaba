package com.xp.colud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: GateWayMain9527
 * @description:
 * @author: XZQ
 * @create: 2020/3/9 11:44
 **/
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class GateWayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class, args);
    }
}
