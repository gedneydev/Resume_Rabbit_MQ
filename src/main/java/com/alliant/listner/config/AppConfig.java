package com.alliant.listner.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${alliant.auth.url}")
    private String authUrl;


    public String getAuthUrl() {
        return authUrl;
    }
}
