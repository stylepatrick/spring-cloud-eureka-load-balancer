package com.example.client.config;

import feign.auth.BasicAuthRequestInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class FeignClientSecurityConfiguration {

    private final AppConfig appConfig;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(appConfig.getServerApiUsername(), appConfig.getServerApiPassword());
    }
}