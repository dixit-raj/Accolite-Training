package com.example.UrbanClone.repository;

import com.example.UrbanClone.entity.ServiceToggleAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceToggleAvailabilityRepository extends JpaRepository<ServiceToggleAvailability, Long> {
    List<ServiceToggleAvailability> findByProviderId(Long providerId);
}
