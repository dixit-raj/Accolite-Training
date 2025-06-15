package com.example.UrbanClone.entity;

import com.sun.jdi.PrimitiveValue;
import jakarta.persistence.*;
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private int rating;

    @ManyToOne
    private Customer reviewer;

    @ManyToOne
    private ServiceProvider target;


}
