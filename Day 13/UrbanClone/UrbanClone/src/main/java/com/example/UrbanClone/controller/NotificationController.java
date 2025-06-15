package com.example.UrbanClone.controller;

import com.example.UrbanClone.entity.Notification;
import com.example.UrbanClone.entity.ServiceProvider;
import com.example.UrbanClone.repository.NotificationRepository;
import com.example.UrbanClone.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepo;
    @Autowired
    private ServiceProviderRepository providerRepo;

    @GetMapping("/my")
    public List<Notification> getMyNotifications(@AuthenticationPrincipal String email) {
        ServiceProvider provider = providerRepo.findByEmail(email);
        if (provider == null) {
            throw new RuntimeException("Service provider not found for email: " + email);
        }
        return notificationRepo.findByServiceProvider(provider);
    }
}
