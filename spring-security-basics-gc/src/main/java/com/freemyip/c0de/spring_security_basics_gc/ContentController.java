package com.freemyip.c0de.spring_security_basics_gc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
    
    @GetMapping("/")
    public String handleWelcome() {
        return "home";
    }
    @GetMapping("/admin/home")
    public String handleAdminHome() {
        return "home_admin";
    }
    @GetMapping("/user/home")
    public String handleUserHome() {
        return "home_user";
    }
    @GetMapping("/login")
    public String handleLogin() {
        return "custom_login";
    }
}
