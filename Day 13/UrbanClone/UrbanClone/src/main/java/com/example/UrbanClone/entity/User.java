package com.example.UrbanClone.entity;


import jakarta.persistence.*;
import lombok.*;


    @Getter @Setter
    @Entity
    @Table(name = "users")
    @Inheritance(strategy = InheritanceType.JOINED)
    public abstract class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        @Column(unique = true)
        private String email;
        private String password;
        private String location;
}
