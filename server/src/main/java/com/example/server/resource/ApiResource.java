package com.example.server.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiResource {

    @RequestMapping("/api")
    public String hello() {
        return "Test Server 1";
    }
}
