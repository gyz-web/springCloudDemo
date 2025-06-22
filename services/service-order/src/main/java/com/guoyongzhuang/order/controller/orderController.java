package com.guoyongzhuang.order.controller;

import com.guoyongzhuang.order.bean.Order;
import com.guoyongzhuang.order.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class orderController {

    @Autowired
    orderService orderService;

    @GetMapping("/create")
    public Order createOrder(@RequestParam Long productId , @RequestParam  Long userId) {

        return orderService.createOrder(productId,userId);

    }
}
