package com.lowdad.dev.discoverydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DiscoveryDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryDemoApplication.class, args);
    }

}
