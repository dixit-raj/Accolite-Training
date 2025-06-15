package com.example.UrbanClone.repository;

import com.example.UrbanClone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //User findByEmail(String email);
}
