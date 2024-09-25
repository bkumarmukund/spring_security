package com.freemyip.c0de.ss_2022_c3_e1.config.security.managers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.freemyip.c0de.ss_2022_c3_e1.config.security.providers.CustomeAuthenticationProvider;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final CustomeAuthenticationProvider customeAuthenticationProvider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (customeAuthenticationProvider.supports(authentication.getClass())) {
            return customeAuthenticationProvider.authenticate(authentication);
        }

        throw new BadCredentialsException("sorry!");
    }
    
}
