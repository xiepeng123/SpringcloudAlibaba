package com.xp.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xp.cloud.entities.CommonResult;
import com.xp.cloud.entities.Payment;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/11/11
 * Time: 22:40
 * Description: No Description
 */

@RestController
//@RequestMapping("/sentinel")
public class FlowLimitController {

  private static final Logger logger = LoggerFactory.getLogger(FlowLimitController.class);

  @RequestMapping("/testA")
  public String testA() {
//    try {
//      TimeUnit.MILLISECONDS.sleep(2000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    return "------testA";
  }

  @RequestMapping("/testB")
  public String testB() {
    try {
      TimeUnit.MILLISECONDS.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    logger.info(Thread.currentThread().getName()+"\t"+"...testB");
    return "------testB";
  }


  @RequestMapping("/testD")
  public String testD() {
    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

//    for(int i=0;i<10;i++){
//      if(i/2==0){
//        int b = 10/0;
//      }
//    }

    Random r = new Random();
    int ran1 = r.nextInt(10);
    System.out.println(ran1);
    if(ran1%2==0){
        int b = 10/0;
      }

    logger.info(Thread.currentThread().getName()+"\t"+"...testddd");
    return "------testDDDD";
  }


  @RequestMapping("/testHotKey")
  @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
  public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                           @RequestParam(value = "p2",required = false) String p2) {
    return "......testHotKey";
  }

  //处理异常的兜底方法, 不配置 blockHandler 就会直接返回错误页面
  // 方法名 对应上面 @SentinelResource 注解配置的 blockHandler = "deal_testHotKey"
  public String deal_testHotKey(String p1,String p2, BlockException blockException){
    return "......deal_testHotKey -_-";
  }


  @RequestMapping("/testBlock")
  @SentinelResource(value = "testBlock",
      blockHandlerClass = CustomerBlockHandler.class,
      blockHandler = "handlerException1")
  public CommonResult testBlock(@RequestParam(value = "p1",required = false) String p1,
      @RequestParam(value = "p2",required = false) String p2) {
     return new CommonResult(200,"客户自定义",new Payment(2020L,"sarial003"));
  }



}
