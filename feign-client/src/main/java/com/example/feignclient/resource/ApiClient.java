package com.example.feignclient.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "${serverApi.serverDiscoveryName}")
public interface ApiClient {
    @RequestMapping("/api")
    String hello();
}