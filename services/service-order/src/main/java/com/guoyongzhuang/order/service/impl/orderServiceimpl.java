package com.guoyongzhuang.order.service.impl;

import com.guoyongzhuang.bean.order.Order;
import com.guoyongzhuang.bean.product.Product;
import com.guoyongzhuang.order.service.orderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class orderServiceimpl implements orderService {
    @Autowired
    DiscoveryClient discoveryClient;

    @Qualifier("myRestTemplate")
    @Autowired RestTemplate myRestTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Override
    public Order createOrder(Long productId, Long userId) {

//        Product productFromRemote = getProductFromRemote(productId);
        Product productFromRemote = getProductFromRemoteWithLoadBalancer(productId);

        BigDecimal num = new BigDecimal(productFromRemote.getNum());
        BigDecimal price = productFromRemote.getPrice();

        Order order = new Order();
        order.setId(1L);
        order.setTotalAmount(num.multiply(price));
        order.setUserId(userId);
        order.setNickName("guoyongzhuang");
        order.setAddress("jinan");


        order.setProductList(Arrays.asList(productFromRemote)); //remote query.

        return order;

    }

    private Product getProductFromRemote(Long productId){
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        ServiceInstance instance = instances.get(0);

        String url="http://"+instance.getHost()+":"+instance.getPort()+"/getProduct/"+productId;

        log.info("remote request url ={}",url);

        Product product = myRestTemplate.getForObject(url, Product.class);



        return product;

    }

    private Product getProductFromRemoteWithLoadBalancer(Long productId){
        ServiceInstance choose = loadBalancerClient.choose("service-product");


        String url="http://"+choose.getHost()+":"+choose.getPort()+"/getProduct/"+productId;

        log.info("remote request url ={}",url);

        Product product = myRestTemplate.getForObject(url, Product.class);



        return product;

    }


}
