package com.cmiot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {
    @Value(value = "${info.profile}")
    private String profileName;

    @RequestMapping(value = "/config")
    public String config(){
        System.out.println(this.profileName);
        return this.profileName;
    }

}
