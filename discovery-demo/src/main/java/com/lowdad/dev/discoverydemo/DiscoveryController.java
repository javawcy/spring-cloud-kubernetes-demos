package com.lowdad.dev.discoverydemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lowdad
 * 2019-10-13
 **/
@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/services")
    public String services() {
        return discoveryClient.getServices().toString();
    }

    @GetMapping("/detail")
    public String getServiceDetail(
            @RequestParam(value = "serviceName", defaultValue = "") String serviceName) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(discoveryClient.getInstances(serviceName));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

}
