package com.xp.cloud.service;

import com.xp.cloud.domain.Order;

public interface OrderService {

  void create(Order order) throws Exception;

  void testFeign();


}
