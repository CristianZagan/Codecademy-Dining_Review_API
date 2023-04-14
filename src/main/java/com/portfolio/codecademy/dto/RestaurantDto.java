package com.portfolio.codecademy.dto;

import com.portfolio.codecademy.model.Restaurant;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    private Long id;
    private String name;
    private String address;
    private double peanutScore;
    private double eggScore;
    private double dairyScore;
    private double overallScore;

    public RestaurantDto(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.address = restaurant.getAddress();
        this.peanutScore = restaurant.getPeanutScore();
        this.eggScore = restaurant.getEggScore();
        this.dairyScore = restaurant.getDairyScore();
        this.overallScore = restaurant.getOverallScore();
    }
}
