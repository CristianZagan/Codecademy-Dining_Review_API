package com.portfolio.codecademy.dto;


import com.portfolio.codecademy.enums.ReviewStatus;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DiningReviewDto {

    private Long id;
    private String reviewerName;
    private Long restaurantId;
    private Integer peanutScore;
    private Integer eggScore;
    private Integer dairyScore;
    private String commentary;
    private ReviewStatus status;

}
