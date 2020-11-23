package com.xp.cloud.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xp.cloud.entities.CommonResult;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/11/22
 * Time: 23:34
 * Description: No Description
 */
public class CustomerBlockHandler {

  public static CommonResult handlerException1(BlockException blockException){
    return new CommonResult(4444,"客户自定义,global handlerException---1");
  }

  public static CommonResult handlerException2(BlockException blockException){
    return new CommonResult(4444,"客户自定义,global handlerException---2");
  }

}
