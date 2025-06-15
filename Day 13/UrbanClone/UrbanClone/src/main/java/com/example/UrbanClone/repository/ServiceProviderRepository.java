package com.example.UrbanClone.repository;

import com.example.UrbanClone.entity.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
    ServiceProvider findByEmail(String email);
}
