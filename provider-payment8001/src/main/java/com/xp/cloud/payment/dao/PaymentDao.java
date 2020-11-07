package com.xp.cloud.payment.dao;


import com.xp.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PaymentDao
 * @description: 支付持久层
 * @author: XZQ
 * @create: 2020/3/5 17:58
 **/
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
