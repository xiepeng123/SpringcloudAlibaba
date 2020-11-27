package com.xp.cloud.service;

import com.xp.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/10/29
 * Time: 15:48
 * Description: No Description
 */
@Service
@FeignClient(value = "provider-payment8001")
public interface PaymentFeignService {

  /**
   * 根据id查询
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/payment/get/{id}")
  CommonResult getPaymentById(@PathVariable("id") Long id);

  /**
   * 模拟feign超时
   *
   * @return
   */
  @RequestMapping(value = "/payment/feign/timeout")
  String paymentFeignTimeout();

  @RequestMapping(value = "/payment/lb")
  String lb();

}
