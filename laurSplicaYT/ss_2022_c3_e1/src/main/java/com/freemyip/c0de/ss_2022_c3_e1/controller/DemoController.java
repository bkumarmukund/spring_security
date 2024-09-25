package com.freemyip.c0de.ss_2022_c3_e1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${spring.application.name}")
    private String appName;
    
    @GetMapping("/demo")
    public String demo() {
        return "demo "+appName;
    }
}
