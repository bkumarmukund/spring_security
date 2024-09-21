package com.freemyip.c0de.ss_2022_c2_e1.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.freemyip.c0de.ss_2022_c2_e1.entities.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityUser implements UserDetails {

    private final User user;
    
    @Override
    public String getPassword() {
        return user.getPassword();
    }
    
    @Override
    public String getUsername() {
        System.out.println(user.getUsername());
        return user.getUsername();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities()
                    .stream()
                    .map(SecurityAuthority::new)
                    .collect(Collectors.toList());
    }
    
}
