package com.xp.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/11/14
 * Time: 20:29
 * Description: No Description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelService8401 {

  public static void main(String[] args) {
    SpringApplication.run(SentinelService8401.class, args);
  }


  @RestController
  static class TestController {

    @GetMapping("/hello")
    public String hello() {
      return "didispace.com";
    }

  }


}
