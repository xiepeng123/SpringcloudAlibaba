package com.xp.cloud.controller;

import com.xp.cloud.entities.CommonResult;
import com.xp.cloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/10/29
 * Time: 15:46
 * Description: No Description
 */
@RestController
@RequestMapping("/consumer")
public class OrderFeignClientController {

  @Autowired
  private PaymentFeignService paymentFeignService;

  /**
   * 根据id查询
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/payment/get/{id}")
  public CommonResult getPaymentById(@PathVariable("id") Long id) {
    return paymentFeignService.getPaymentById(id);
  }

  /**
   * 模拟feign超时
   *
   * @return
   */
  @GetMapping(value = "/payment/feign/timeout")
  public String paymentFeignTimeout() {
    // openfeign-ribbon, 客户端一般默认等待1秒钟
    return paymentFeignService.paymentFeignTimeout();
  }


}
