package com.portfolio.codecademy.service;

import com.portfolio.codecademy.converter.DiningReviewMapper;
import com.portfolio.codecademy.converter.RestaurantMapper;
import com.portfolio.codecademy.dto.DiningReviewDto;
import com.portfolio.codecademy.dto.RestaurantDto;
import com.portfolio.codecademy.exception.RestaurantNotFoundException;
import com.portfolio.codecademy.model.DiningReview;
import com.portfolio.codecademy.model.Restaurant;
import com.portfolio.codecademy.repository.DiningReviewRepository;
import com.portfolio.codecademy.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final DiningReviewRepository reviewRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, DiningReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
    }

    public RestaurantDto getRestaurantById(Long restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        return restaurant.map(RestaurantMapper::toDto).orElse(null);
    }

    public List<DiningReviewDto> getReviewsForRestaurant(Long restaurantId) {
        List<DiningReview> reviews = reviewRepository.findByRestaurantId(restaurantId);
        return reviews.stream().map(DiningReviewMapper::toDto).collect(Collectors.toList());
    }

    public DiningReviewDto createReviewForRestaurant(Long restaurantId, DiningReviewDto reviewDto) {
        reviewDto.setRestaurantId(restaurantId);
        DiningReview review = DiningReviewMapper.toEntity(reviewDto);
        DiningReview savedReview = reviewRepository.save(review);
        return DiningReviewMapper.toDto(savedReview);
    }

    public DiningReviewDto updateReviewForRestaurant(Long restaurantId, Long reviewId, DiningReviewDto reviewDto) {
        Optional<DiningReview> existingReview = reviewRepository.findById(reviewId);
        if (existingReview.isPresent() && existingReview.get().getRestaurant().getId().equals(restaurantId)) {
            DiningReview updatedReview = DiningReviewMapper.toEntity(reviewDto);
            updatedReview.setId(reviewId);
            updatedReview.setRestaurant(existingReview.get().getRestaurant());
            DiningReview savedReview = reviewRepository.save(updatedReview);
            return DiningReviewMapper.toDto(savedReview);
        }
        return null;
    }

    public void deleteReviewForRestaurant(Long restaurantId, Long reviewId) {
        Optional<DiningReview> existingReview = reviewRepository.findById(reviewId);
        if (existingReview.isPresent() && existingReview.get().getRestaurant().getId().equals(restaurantId)) {
            reviewRepository.delete(existingReview.get());
        }
    }

    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = RestaurantMapper.toEntity(restaurantDto);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return RestaurantMapper.toDto(savedRestaurant);
    }

    public RestaurantDto updateRestaurant(Long id, RestaurantDto restaurantDto) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            restaurant.setName(restaurantDto.getName());
            restaurant.setAddress(restaurantDto.getAddress());
            Restaurant savedRestaurant = restaurantRepository.save(restaurant);
            return RestaurantMapper.toDto(savedRestaurant);
        } else {
            throw new RestaurantNotFoundException("Restaurant not found with id: " + id);
        }
    }

    public boolean deleteRestaurant(Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            restaurantRepository.deleteById(id);
            return true;
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }
}
