package com.xp.cloud.controller;

import com.xp.cloud.domain.Order;
import com.xp.cloud.entities.CommonResult;
import com.xp.cloud.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping("/test")
    public String test(){
        orderService.testFeign();
        return "test";
    }

    @RequestMapping("/order/create")
    public CommonResult create(Order order) {

        try {
            orderService.create(order);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResult(111,"订单创建失败，"+e.getMessage());
        }
        return new CommonResult(200,"订单创建成功");
    }

}
