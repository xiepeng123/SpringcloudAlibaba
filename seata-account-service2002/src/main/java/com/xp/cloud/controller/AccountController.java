package com.xp.cloud.controller;

import com.xp.cloud.entities.CommonResult;
import com.xp.cloud.service.AccountService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult(200,"订单创建成功");
    }


}
