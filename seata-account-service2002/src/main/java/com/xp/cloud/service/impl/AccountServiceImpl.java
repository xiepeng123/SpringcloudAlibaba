package com.xp.cloud.service.impl;

import com.xp.cloud.dao.AccountDao;
import com.xp.cloud.service.AccountService;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/12/2
 * Time: 23:08
 * Description: No Description
 */
@Service
public class AccountServiceImpl implements AccountService {

  private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

  @Resource
  private AccountDao accountDao;

  @Override
  public void decrease(Long userId, BigDecimal money) {
    logger.info("------>account-service中 扣 余额 start ");
    accountDao.decrease(userId,money);
    logger.info("------>account-service中 扣 余额 end ");
  }

}
