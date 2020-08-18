package com.example.springsecurityjwt.repository;

import com.example.springsecurityjwt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public UserDetails findByUserName(String username);
}
