package com.example.UrbanClone.repository;

import com.example.UrbanClone.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByTargetId(Long providerId);
}
