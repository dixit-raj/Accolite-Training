package com.example.UrbanClone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "customers")
@PrimaryKeyJoinColumn(name="id")
public class Customer extends User {
    private Double walletBalance = 0.0;
}