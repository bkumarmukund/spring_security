package com.freemyip.c0de.ss_2022_c2_e1.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${secret.message}")
    String message;

    @GetMapping("/")
    public String hello() {

        // var sc = SecurityContextHolder.getContext().getAuthentication();
        // sc.getAuthorities().forEach((a)->System.out.println(a));

        return message + "\nauthentication: see log";
    }
}
