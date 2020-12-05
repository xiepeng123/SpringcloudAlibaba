package com.xp.cloud.service;

import com.xp.cloud.entities.CommonResult;
import java.math.BigDecimal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @RequestMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);

}
