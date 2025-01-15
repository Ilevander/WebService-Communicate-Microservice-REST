package com.ilyass.webapp.repository;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.ilyass.webapp")
@Data
public class CustomProperties {
    private String apiUrl;
}
