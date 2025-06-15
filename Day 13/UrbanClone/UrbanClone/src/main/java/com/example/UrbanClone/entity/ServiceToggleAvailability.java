package com.example.UrbanClone.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class ServiceToggleAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private LocalDate date;
    private boolean active;

    @ManyToOne
    private ServiceProvider provider;
}
