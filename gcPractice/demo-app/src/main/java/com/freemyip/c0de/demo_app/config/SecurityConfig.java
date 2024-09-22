package com.freemyip.c0de.demo_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(r->{
            r.requestMatchers("/home").permitAll();
            r.requestMatchers("/admin").hasRole("admin");
            r.requestMatchers("/user").hasRole("user");
            r.anyRequest().authenticated();
        }).build();
    }

}
