package com.freemyip.c0de.ss_2022_c2_e1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freemyip.c0de.ss_2022_c2_e1.entities.User;


public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByUsername(String username);
}
