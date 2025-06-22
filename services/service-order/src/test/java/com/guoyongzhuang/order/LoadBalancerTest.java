package com.guoyongzhuang.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@SpringBootTest
public class LoadBalancerTest {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Test
    void test() {

        for (int i = 0; i < 10; i++) {
            ServiceInstance choose = loadBalancerClient.choose("service-product");
            System.out.println(choose.getUri() + ":" + choose.getPort());
        }

    }
}
