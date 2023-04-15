package com.portfolio.codecademy.controller;

import com.portfolio.codecademy.dto.RestaurantDto;
import com.portfolio.codecademy.service.RestaurantService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable("id") Long id) {
        Optional<RestaurantDto> restaurant = Optional.ofNullable(restaurantService.getRestaurantById(id));
        return restaurant.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody @Validated RestaurantDto restaurantDto) {
        RestaurantDto createdRestaurant = restaurantService.createRestaurant(restaurantDto);
        return ResponseEntity.created(URI.create("/api/restaurants/" + createdRestaurant.getId())).body(createdRestaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable("id") Long id, @RequestBody @Validated RestaurantDto restaurantDto) {
        Optional<RestaurantDto> updatedRestaurant = Optional.ofNullable(restaurantService.updateRestaurant(id, restaurantDto));
        return updatedRestaurant.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        boolean deleted = restaurantService.deleteRestaurant(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
