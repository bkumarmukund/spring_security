package com.freemyip.c0de.spring_security_basics_gc.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freemyip.c0de.spring_security_basics_gc.model.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser,Long> {
    Optional<MyUser> findByUsername(String username);
}
