package com.xp.cloud.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/12/2
 * Time: 23:13
 * Description: No Description
 */
public interface StorageService {

  void decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);

}
