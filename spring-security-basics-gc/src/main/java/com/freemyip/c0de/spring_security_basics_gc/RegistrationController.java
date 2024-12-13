package com.freemyip.c0de.spring_security_basics_gc;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.freemyip.c0de.spring_security_basics_gc.model.MyUser;
import com.freemyip.c0de.spring_security_basics_gc.repo.MyUserRepository;

@RestController
public class RegistrationController {

    private MyUserRepository myUserRepository;
    private PasswordEncoder passwordEncoder;


    public RegistrationController(MyUserRepository myUserRepository, PasswordEncoder passwordEncoder) {
        this.myUserRepository = myUserRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @PostMapping("/register/user")
    public MyUser createUser(@RequestBody MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return myUserRepository.save(user);
    }

}
