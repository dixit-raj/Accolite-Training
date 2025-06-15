package com.example.UrbanClone.repository;

import com.example.UrbanClone.entity.Notification;
import com.example.UrbanClone.entity.ServiceProvider;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
   // Notification findByEmail(String email);
    List<Notification> findByServiceProvider(ServiceProvider serviceProvider);
}
