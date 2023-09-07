package com.practice.foody.config;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TastyApiConfig {
    @Value("${tasty.api.endpoint}")
    private String tastyApiEndpoint;
    @Value("${tasty.api.key}")
    private String tastyApiKey;
    @Value("${tasty.api.host}")
    private String tastyApiHost;
}
