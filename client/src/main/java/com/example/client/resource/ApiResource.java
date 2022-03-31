package com.example.client.resource;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApiResource implements ApiClient {

    private final ApiClient apiClient;

    @RequestMapping("/api")
    public String hello() {
        return apiClient.hello();
    }

}
