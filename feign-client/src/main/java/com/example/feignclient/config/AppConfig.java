package com.example.feignclient.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter(AccessLevel.PROTECTED)
@Component
public class AppConfig {

    @Value("${serverApi.username}")
    private String serverApiUsername;

    @Value("${serverApi.password}")
    private String serverApiPassword;
}
