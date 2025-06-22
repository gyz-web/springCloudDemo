package com.guoyongzhuang.product;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class DiscoveryTest {
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    NacosServiceDiscovery nacosServiceDiscovery;

    @Test
    void nacosServiceDiscoveryTest() throws NacosException {
        List<String> services = nacosServiceDiscovery.getServices();
        for(String service : services){
            System.out.println("service= "+service);
            List<ServiceInstance> instances = nacosServiceDiscovery.getInstances(service);
            for (ServiceInstance instance:instances){
                System.out.println(instance.getUri());
                System.out.println(instance.getPort());
                System.out.println(instance.getInstanceId());

            }
        }

    }
    @Test
    void discoveryClientTest(){
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            System.out.println("service= "+service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance:instances){
                System.out.println(instance.getUri());
                System.out.println(instance.getPort());
                System.out.println(instance.getInstanceId());

            }
        }

    }
}
