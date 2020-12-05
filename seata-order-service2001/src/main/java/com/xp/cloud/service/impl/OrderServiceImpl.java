package com.xp.cloud.service.impl;

import com.xp.cloud.dao.OrderDao;
import com.xp.cloud.domain.Order;
import com.xp.cloud.service.AccountService;
import com.xp.cloud.service.OrderService;
import com.xp.cloud.service.StroageService;
import io.seata.spring.annotation.GlobalTransactional;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: xp
 * Date: 2020/11/29
 * Time: 23:45
 * Description: No Description
 */
@Service
public class OrderServiceImpl implements OrderService {

  private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

  @Resource
  private OrderDao orderDao;

  @Resource
  private AccountService accountService;

  @Resource
  private StroageService stroageService;

  @Override
  @GlobalTransactional(name = "my_test_tx_group")
  public void create(Order order) {

    logger.info("--->开始创建订单");
    orderDao.create(order);

    logger.info("--->订单微服务开始调用库存,扣减库存数量 count 开始...");
    stroageService.decrease(order.getProductId(),order.getCount());
    logger.info("--->订单微服务开始调用库存,做扣减 结束...");

    logger.info("--->订单微服务开始调用账户,扣减账户余额 money 开始...");
    accountService.decrease(order.getUserId(),order.getMoney());
    logger.info("--->订单微服务开始调用账户,做扣减 结束...");

    //修改订单状态 0->1 1代表已完成
    logger.info("--->修改订单状态开始...");
    orderDao.update(order.getUserId(),0);
    logger.info("--->修改订单状态结束...");

    logger.info("--->下单结束了 哈哈 ~~~...");

  }

  @Override
  @GlobalTransactional
  public void testFeign() {
    stroageService.testFeign();
  }


}
