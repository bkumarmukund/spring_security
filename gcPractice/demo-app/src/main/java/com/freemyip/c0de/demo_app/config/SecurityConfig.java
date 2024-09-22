package com.freemyip.c0de.demo_app.config;

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

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(r -> {
            r.requestMatchers("/home").permitAll();
            r.requestMatchers("/admin/**").hasRole("admin");
            r.requestMatchers("/user/**").hasRole("user");
            r.anyRequest().authenticated();
        })
        .formLogin(formLogin->formLogin.permitAll())
        .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userOne = User.builder()
                .username("rob")
                .password("$2a$12$u2EgVbfBlR9eOV9wEu6a9u7mvEn0DqTsjjqZ30P1YYNLLVjdnkRe6")
                // password is greenfield
                .roles("user")
                .build();
        UserDetails userZero = User.builder()
                .username("amba")
                .password("$2a$12$yabqHKEiEZrLWX4ehxMo0e92.48npEJoA0GW/Gkt/4kDStDG8y9M.")
                // password is raya
                .roles("admin","user")
                .build();

        return new InMemoryUserDetailsManager(userOne,userZero);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
