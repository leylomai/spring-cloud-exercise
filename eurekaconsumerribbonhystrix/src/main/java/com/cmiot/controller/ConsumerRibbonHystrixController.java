package com.cmiot.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerRibbonHystrixController {
    /*@Autowired
    private LoadBalancerClient loadBalancerClient;*/
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumerribbon")
    @HystrixCommand(fallbackMethod = "hystrixFallback")
    public void cd(){
        /*ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        System.out.println(instance);
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/dc";
        System.out.println("*******" + url + "*******");
        String value = restTemplate.getForObject(url, String.class);
        System.out.println(value);*/
        String value = restTemplate.getForObject("http://eureka-client/dc", String.class);
        System.out.println(value);
    }

    public void hystrixFallback(){
        System.out.println("hystrixFallback");
    }
}
