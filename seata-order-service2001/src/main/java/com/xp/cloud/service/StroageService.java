package com.xp.cloud.service;

import com.xp.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "seata-storage-service")
public interface StroageService {

    @RequestMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);

    @RequestMapping("/storage/test")
    void testFeign();


}
