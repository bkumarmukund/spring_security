package com.freemyip.c0de.spring_security_basics_gc.model;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.freemyip.c0de.spring_security_basics_gc.repo.MyUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

    private final MyUserRepository repository;

    
    public MyUserDetailsService(MyUserRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<MyUser> user = repository.findByUsername(username);
        if(user.isPresent()) {
            var userFromDB = user.get();
            return User.builder()
                .username(userFromDB.getUsername())
                .password(userFromDB.getPassword())
                .roles(getRoles(userFromDB))
                .build();

        }else {
            throw new UsernameNotFoundException(username+" does not exist");
        }
    }

    private String[] getRoles(MyUser user) {
        if(user.getRole() == null) {
            return new String[]{"USER"};
        }
        return user.getRole().split(",");
    }
    
}
