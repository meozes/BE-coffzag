package com.mini.coffzag.controller;

import com.mini.coffzag.dto.ReviewDto;
import com.mini.coffzag.entity.User;
import com.mini.coffzag.response.ReturnReview;
import com.mini.coffzag.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    //상세페이지 (커피 상세 + 댓글)
    @GetMapping("/api/details/{coffeeId}")
    public ReturnReview getDetailsWithReview(@PathVariable Long coffeeId){
        return reviewService.getDetailsWithReview(coffeeId);
    }

    @PostMapping("/api/reviews/{coffeeId}") //댓글 단 사람 필요
    public void createReview(@PathVariable Long coffeeId, @RequestBody ReviewDto reviewDto, @AuthenticationPrincipal User user){
        String username = user.getUsername();
        reviewDto.setUsername(username);
        reviewDto.setCoffeeId(coffeeId);
        reviewService.createReview(reviewDto);
    }

}
