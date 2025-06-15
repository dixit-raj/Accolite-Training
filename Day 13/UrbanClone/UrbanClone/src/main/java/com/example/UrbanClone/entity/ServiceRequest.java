package com.example.UrbanClone.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity
@Getter @Setter

public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    private String category;
    private String description;
    private String location;
    private LocalDate date;
    private String status;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private ServiceProvider provider;
}


