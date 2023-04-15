package com.portfolio.codecademy.repository;

import com.portfolio.codecademy.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

//    List<Restaurant> findByAddressZipcodeAndAllergies(String zipcode, String allergy);


}
