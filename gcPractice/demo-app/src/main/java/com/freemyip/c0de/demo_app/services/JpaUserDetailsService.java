package com.freemyip.c0de.demo_app.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.freemyip.c0de.demo_app.entities.User;
import com.freemyip.c0de.demo_app.repositories.UserRepository;
import com.freemyip.c0de.demo_app.security.SecurityUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return new SecurityUser(null);

        // TODO complete JpaUserDetailsService
    }
    
    
}
