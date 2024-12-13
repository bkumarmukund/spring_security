package com.freemyip.c0de.spring_security_basics_gc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeRequests(registry->{
            registry.requestMatchers("/home").permitAll();
            registry.requestMatchers("/admin/**").hasRole("ADMIN");
            registry.requestMatchers("/user/**").hasRole("USER");
            registry.anyRequest().authenticated();
        })
        .formLogin(fl->fl.permitAll())
        .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normalUser = User.builder()
            .username("solanki")
            .password("$2a$12$UG8zLEIO3jSI.iR9fOciB.Y3j1WzwAQxuouiDeV56f7m6nnL8F/9a")
            .roles("USER")
            .build();

        UserDetails adminUser = User.builder()
            .username("ankit")
            .password("$2a$12$QYDPA/pGf2t89JsQ1IvG6OyZ4GPMq1ydYrz212/OJ83FZNMHUSD3S")
            .roles("ADMIN","USER")
            .build();

        return new InMemoryUserDetailsManager(normalUser,adminUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
