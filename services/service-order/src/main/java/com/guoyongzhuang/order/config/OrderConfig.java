package com.guoyongzhuang.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class OrderConfig {
    @Bean("myRestTemplate")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
