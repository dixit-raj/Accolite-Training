package com.example.UrbanClone.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Getter @Setter
@Table(name = "service_providers")
@PrimaryKeyJoinColumn(name="id")
public class ServiceProvider extends User {
    @ElementCollection
    private List<String> categories = new ArrayList<>();
    private Boolean available = true;
    private Double walletBalance = 0.0;

}

