package com.guoyongzhuang.order.controller;

import com.guoyongzhuang.bean.order.Order;
import com.guoyongzhuang.order.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope // 激活配置自动刷新功能
@RestController
public class orderController {

    @Autowired
    orderService orderService;

    // 获取Nacos中的配置
    @Value("${order.timeout}")
    String orderTimeout;
    @Value("${order.auto-confirm}")
    String orderAutoConfirm;
    @GetMapping("/getConfig")
    public String getConfig() {
        return "orderTimeout: " + orderTimeout +
                ", orderAutoConfirm: " +orderAutoConfirm ;
    }

    @GetMapping("/create")
    public Order createOrder(@RequestParam Long productId , @RequestParam  Long userId) {

        return orderService.createOrder(productId,userId);

    }
}
