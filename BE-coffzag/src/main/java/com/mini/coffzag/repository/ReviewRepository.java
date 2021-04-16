package com.mini.coffzag.repository;

import com.mini.coffzag.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCoffeeIdOrderByCreatedAt(Long coffeeId);
    Review findByReviewId(Long reviewId);
    Review findOneByCoffeeIdAndOrderByCreatedAtDesc(Long coffeeId);
}
