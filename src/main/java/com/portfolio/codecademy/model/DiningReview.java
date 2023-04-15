package com.portfolio.codecademy.model;

import com.portfolio.codecademy.enums.ReviewStatus;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.*;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reviewerName;

    @ManyToOne
    private Restaurant restaurant;
    private Integer peanutScore;
    private Integer eggScore;
    private Integer dairyScore;
    private String commentary;

    @Enumerated(EnumType.STRING)
    private ReviewStatus status;
}
