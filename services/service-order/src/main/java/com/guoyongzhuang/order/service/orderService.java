package com.guoyongzhuang.order.service;

import com.guoyongzhuang.order.bean.Order;

public interface orderService {

    Order createOrder(Long productId , Long userId);
}
