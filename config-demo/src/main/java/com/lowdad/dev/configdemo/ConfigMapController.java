package com.lowdad.dev.configdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lowdad
 * 2019-10-13
 **/
@RestController
public class ConfigMapController {


    @Value("${message}")
    private String message;

    @GetMapping("msg")
    public String getMessage() {
        return "Message is : " + message;
    }
}
