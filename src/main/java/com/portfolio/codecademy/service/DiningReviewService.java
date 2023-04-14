package com.portfolio.codecademy.service;

import com.portfolio.codecademy.enums.ReviewStatus;
import com.portfolio.codecademy.model.DiningReview;
import com.portfolio.codecademy.repository.DiningReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiningReviewService {

    private DiningReviewRepository diningReviewRepository;

    @Autowired
    public DiningReviewService(DiningReviewRepository diningReviewRepository) {
        this.diningReviewRepository = diningReviewRepository;
    }

    public List<DiningReview> getAllDiningReviewByStatus(ReviewStatus status) {
        return diningReviewRepository.findAllByStatusOrderByStatus(status);
    }

    public List<DiningReview> getAllDiningReviewsByRestaurantIdAndStatus(Long restaurantId, ReviewStatus status) {
        return diningReviewRepository.findAllByRestaurant_IdAndStatus(restaurantId, status);
    }
    public List<DiningReview> getAllDiningReviewsByRestaurantIdAndStatusAndPeanutScore
            (Long restaurantId, ReviewStatus status, Integer peanutScore) {
        return diningReviewRepository.findAllByRestaurant_IdAndStatusAndPeanutScore(restaurantId, status, peanutScore);
    }

    public List<DiningReview> getAllDiningReviewsByRestaurantIdAndStatusAndEggScore
            (Long restaurantId, ReviewStatus status, Integer eggScore) {
        return diningReviewRepository.findAllByRestaurant_IdAndStatusAndEggScore(restaurantId, status, eggScore);
    }

    public List<DiningReview> getAllDiningReviewsByRestaurantIdAndStatusAndDairyScore
            (Long restaurantId, ReviewStatus status, Integer dairyScore) {
        return diningReviewRepository.findAllByRestaurant_IdAndStatusAndDairyScore(restaurantId, status, dairyScore);
    }

    public DiningReview createDiningReview(DiningReview diningReview) {
        return diningReviewRepository.save(diningReview);
    }

    public DiningReview getDiningReviewById(Long id) {
        return diningReviewRepository.findById(id).orElse(null);
    }

    public DiningReview updateDiningReview(DiningReview diningReview) {
        return diningReviewRepository.save(diningReview);
    }

    public void deleteDiningReview(Long id) {
        diningReviewRepository.deleteById(id);
    }


}
