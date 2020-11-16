package com.xp.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/11/11
 * Time: 22:40
 * Description: No Description
 */

@RestController
//@RequestMapping("/payment/test")
public class FlowLimitController {

  @SentinelResource("testA")
  @RequestMapping("/testA")
  public String testA() {
    return "------testA";
  }

  @RequestMapping("/testB")
  public String testB() {
    return "------testB";
  }

}
