package com.example.UrbanClone.controller;

import com.example.UrbanClone.repository.CustomerRepository;
import com.example.UrbanClone.repository.ServiceProviderRepository;
import com.example.UrbanClone.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/report")
public class ReportingController {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ServiceProviderRepository providerRepo;

    @Autowired
    private ServiceRequestRepository requestRepo;

    @GetMapping("/stats")
    public Map<String, Long> getStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("active_customers", customerRepo.count());
        stats.put("active_providers", providerRepo.count());
        stats.put("active_requests", requestRepo.count());
        return stats;

    }

}


