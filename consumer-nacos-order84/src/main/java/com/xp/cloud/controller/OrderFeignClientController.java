package com.xp.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xp.cloud.entities.CommonResult;
import com.xp.cloud.entities.Payment;
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

  @GetMapping(value = "/payment/lb")
  public String lb() {
    return paymentFeignService.lb();
  }


  @GetMapping(value = "/fallback/{id}")
//  @SentinelResource(value = "fallback") //没有配置
//  @SentinelResource(value = "fallback", fallback = "handler_fallback")  //只配置fallback
  //@SentinelResource(value = "fallback", blockHandler = "handler_block")  //只配置 blockHandler
  @SentinelResource(value = "fallback",fallback = "handler_fallback", blockHandler = "handler_block",exceptionsToIgnore = IllegalArgumentException.class)  //都配置
  public CommonResult fallback(@PathVariable Long id) {
    CommonResult result = paymentFeignService.getPaymentById(id);
    if(id == 4){
      throw new IllegalArgumentException("IllegalArgumentException ... 非法参数异常");
    }else if(result.getData() == null ){
      throw new NullPointerException("NullPointerException ... 该ID没有对应记录");
    }
    return result;
  }


  public CommonResult handler_block(@PathVariable Long id,BlockException e){
    Payment payment = new Payment(id,null);
    return new  CommonResult(555,"兜底程序 sentinel 控制台违规配置 的异常处理方法 handler_fallback, exception:"+e.getMessage(),payment);
  }


  // 方法名 对应上面 @SentinelResource 注解配置的 blockHandler = "handler_fallback"
  public CommonResult handler_fallback(@PathVariable Long id,Throwable e){
    Payment payment = new Payment(id,null);
    return new  CommonResult(444,"兜底程序运行时异常处理方法 handler_fallback, exception:"+e.getMessage(),payment);
  }


}