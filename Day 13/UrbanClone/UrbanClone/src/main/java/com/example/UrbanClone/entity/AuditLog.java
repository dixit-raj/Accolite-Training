package com.example.UrbanClone.entity;

import io.micrometer.core.instrument.step.StepRegistryConfig;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter@Setter
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String action;
    private String performedBy;
    private String details;
    private LocalDateTime timestamp = LocalDateTime.now();
}
