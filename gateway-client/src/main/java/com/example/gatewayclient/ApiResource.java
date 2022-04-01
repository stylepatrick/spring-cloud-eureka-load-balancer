package com.example.gatewayclient;

import com.example.gatewayclient.config.AppConfig;
import lombok.AllArgsConstructor;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
public class ApiResource {

    private final AppConfig appConfig;

    @RequestMapping("/api")
    public String hello1() {
        RetryTemplate template = RetryTemplate.builder()
                .maxAttempts(3)
                .build();
        return template.execute(ctx -> getServerValue());
    }

    private String getServerValue()
    {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor(appConfig.getServerApiUsername(), appConfig.getServerApiPassword()));
        return restTemplate.getForObject(appConfig.getServerApiGatewayUrl(), String.class);
    }

}
