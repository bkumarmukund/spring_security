package com.freemyip.c0de.ss_2022_c2_e1.security;

import org.springframework.security.core.GrantedAuthority;

import com.freemyip.c0de.ss_2022_c2_e1.entities.Authority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority{

    private final Authority authority;

    @Override
    public String getAuthority() {
        return authority.getName();
    }
    
}
