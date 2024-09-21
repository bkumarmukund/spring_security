package com.freemyip.c0de.ss_2022_c1_e1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {
    
    @Bean
    public UserDetailsService userDetailsService() {

        var uds = new InMemoryUserDetailsManager();

        UserDetails userOne = User.withUsername("yumna")
            .password("zaidi")
            .authorities("read")
            .build();

        uds.createUser(userOne);

        return uds;
    }   
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
