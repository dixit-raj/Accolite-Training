package com.example.UrbanClone.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class AvailabilitySlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalDate startTime;
    private LocalDate endTime;
    private boolean available;

    @ManyToOne
    private ServiceProvider provider;
}
