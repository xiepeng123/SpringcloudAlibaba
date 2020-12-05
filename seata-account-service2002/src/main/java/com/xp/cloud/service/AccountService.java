package com.xp.cloud.service;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/12/2
 * Time: 23:08
 * Description: No Description
 */
public interface AccountService {

  void decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);


}
