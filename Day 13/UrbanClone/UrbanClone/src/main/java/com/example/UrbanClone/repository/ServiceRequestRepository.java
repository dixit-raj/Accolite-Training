package com.example.UrbanClone.repository;

import com.example.UrbanClone.entity.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
    //ServiceRequest findByEmail(String email);

}
