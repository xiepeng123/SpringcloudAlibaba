package com.xp.cloud.dao;

import com.xp.cloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

    //新建订单
    int create(Order order);

    //修改订单状态 0->1

    int update(@Param("userId") Long userId,@Param("status") Integer status);


}
