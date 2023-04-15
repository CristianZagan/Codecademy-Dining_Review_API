package com.portfolio.codecademy.converter;

import com.portfolio.codecademy.dto.RestaurantDto;
import com.portfolio.codecademy.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {

    public static RestaurantDto toDto(Restaurant restaurant) {
        return RestaurantDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .peanutScore(restaurant.getPeanutScore())
                .eggScore(restaurant.getEggScore())
                .dairyScore(restaurant.getDairyScore())
                .overallScore(restaurant.getOverallScore())
                .build();
    }

    public static Restaurant toEntity(RestaurantDto restaurantDto) {
        return Restaurant.builder()
                .id(restaurantDto.getId())
                .name(restaurantDto.getName())
                .address(restaurantDto.getAddress())
                .peanutScore(restaurantDto.getPeanutScore())
                .eggScore(restaurantDto.getEggScore())
                .dairyScore(restaurantDto.getDairyScore())
                .overallScore(restaurantDto.getOverallScore())
                .build();
    }
}
