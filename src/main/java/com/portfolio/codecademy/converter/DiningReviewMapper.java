package com.portfolio.codecademy.converter;

import com.portfolio.codecademy.dto.DiningReviewDto;
import com.portfolio.codecademy.model.DiningReview;
import org.springframework.stereotype.Component;

@Component
public class DiningReviewMapper {

    public static DiningReviewDto toDto(DiningReview review) {
        return DiningReviewDto.builder()
                .id(review.getId())
                .reviewerName(review.getReviewerName())
                .restaurantId(review.getRestaurant().getId())
                .peanutScore(review.getPeanutScore())
                .eggScore(review.getEggScore())
                .dairyScore(review.getDairyScore())
                .commentary(review.getCommentary())
                .status(review.getStatus())
                .build();
    }

    public static DiningReview toEntity(DiningReviewDto reviewDto) {
        return DiningReview.builder()
                .id(reviewDto.getId())
                .reviewerName(reviewDto.getReviewerName())
                .peanutScore(reviewDto.getPeanutScore())
                .eggScore(reviewDto.getEggScore())
                .dairyScore(reviewDto.getDairyScore())
                .commentary(reviewDto.getCommentary())
                .status(reviewDto.getStatus())
                .build();
    }
}
