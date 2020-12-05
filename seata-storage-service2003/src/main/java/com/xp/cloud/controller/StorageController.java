package com.xp.cloud.controller;

import com.xp.cloud.entities.CommonResult;
import com.xp.cloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    @RequestMapping("/decrease")
    public CommonResult decrease(Long productId, Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"库存扣减成功");
    }


    @RequestMapping("/test")
    public String test(){
        return "testFeign";
    }


}
