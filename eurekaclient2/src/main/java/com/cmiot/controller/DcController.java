package com.cmiot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class DcController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dc")
    public String dc(){
        List<String> serviceList = discoveryClient.getServices();
        StringBuffer sb = new StringBuffer();
        serviceList.parallelStream().forEach(v -> {sb.append(v);System.out.println(v);});
        System.out.println("22222222222222");
        return sb.toString();
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(@RequestPart(value = "file") MultipartFile file){
        System.out.println("file = [" + file + "]");
        return file.getName();
    }
}
