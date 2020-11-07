package com.xp.cloud.payment.service;

import com.xp.cloud.entities.Payment;
import com.xp.cloud.payment.dao.PaymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: PaymentServiceImpl
 * @description:
 * @author: XZQ
 * @create: 2020/3/5 18:19
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
