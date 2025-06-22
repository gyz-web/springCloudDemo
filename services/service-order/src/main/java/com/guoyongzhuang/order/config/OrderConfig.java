package com.guoyongzhuang.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class OrderConfig {
    @LoadBalanced //此注解就表示restTemplate是负载均衡调用的
    @Bean("myRestTemplate")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

