package com.portfolio.codecademy.repository;

import com.portfolio.codecademy.enums.ReviewStatus;
import com.portfolio.codecademy.model.DiningReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiningReviewRepository extends JpaRepository<DiningReview, Long> {

    List<DiningReview> findAllByStatusOrderByStatus(ReviewStatus status);

    List<DiningReview> findAllByRestaurant_IdAndStatus(Long restaurantId, ReviewStatus status);

    List<DiningReview> findAllByRestaurant_IdAndStatusAndPeanutScore(Long restaurantId, ReviewStatus status, Integer peanutScore);

    List<DiningReview> findAllByRestaurant_IdAndStatusAndEggScore(Long restaurantId, ReviewStatus status, Integer eggScore);

    List<DiningReview> findAllByRestaurant_IdAndStatusAndDairyScore(Long restaurantId, ReviewStatus status, Integer dairyScore);

}
