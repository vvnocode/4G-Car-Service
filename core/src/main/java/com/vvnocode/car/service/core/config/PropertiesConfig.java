package com.vvnocode.car.service.core.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties
@Getter
public class PropertiesConfig {

    private Map<String, String> user = new HashMap<>();
}
