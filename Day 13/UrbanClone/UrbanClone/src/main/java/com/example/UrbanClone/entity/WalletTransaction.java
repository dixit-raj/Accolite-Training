package com.example.UrbanClone.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    private String type; // add, pay, withdraw
    private Double amount;
    private LocalDateTime timestamp = LocalDateTime.now();
    private String category;
    private Double handlingFee;

    @ManyToOne
    private User user;
}


