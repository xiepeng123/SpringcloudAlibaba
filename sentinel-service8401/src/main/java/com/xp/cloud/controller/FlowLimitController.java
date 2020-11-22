package com.xp.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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



}
