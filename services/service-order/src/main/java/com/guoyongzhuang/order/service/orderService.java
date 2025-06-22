package com.guoyongzhuang.order.service;


import com.guoyongzhuang.bean.order.Order;

public interface orderService {

    Order createOrder(Long productId , Long userId);
}
