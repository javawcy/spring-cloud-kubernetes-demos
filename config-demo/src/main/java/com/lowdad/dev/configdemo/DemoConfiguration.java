package com.lowdad.dev.configdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lowdad
 * 2019-10-13
 **/
@Configuration
@ConfigurationProperties(prefix = "config")
public class DemoConfigration {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
