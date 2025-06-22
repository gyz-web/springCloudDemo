package com.guoyongzhuang.order.service.impl;

import com.guoyongzhuang.order.bean.Order;
import com.guoyongzhuang.order.service.orderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class orderServiceimpl implements orderService {
    @Override
    public Order createOrder(Long productId, Long userId) {
        Order order = new Order();
        order.setId(1L);
        order.setTotalAmount(new BigDecimal("0"));
        order.setUserId(userId);
        order.setNickName("guoyongzhuang");
        order.setAddress("jinan");
        order.setProductList(null); //remote query.

        return order;

    }
}
