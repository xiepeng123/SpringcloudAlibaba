package com.xp.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/10/29
 * Time: 15:44
 * Description: No Description
 */
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients//启用feign客户端
public class NacosOrder84 {
  public static void main(String[] args) {
    SpringApplication.run(NacosOrder84.class, args);
  }
}
