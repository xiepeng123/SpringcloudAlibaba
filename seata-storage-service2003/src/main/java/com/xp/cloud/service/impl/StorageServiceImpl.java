package com.xp.cloud.service.impl;

import com.xp.cloud.dao.StorageDao;
import com.xp.cloud.service.StorageService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/12/2
 * Time: 23:14
 * Description: No Description
 */
@Service
public class StorageServiceImpl implements StorageService {

  private static final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);

  @Resource
  private StorageDao storageDao;

  @Override
  public void decrease(Long productId, Integer count) {
    logger.info("------>storage-service中 扣减库存 start ");
    storageDao.decrease(productId,count);
    logger.info("------>storage-service中 扣减库存 end ");
  }


}
