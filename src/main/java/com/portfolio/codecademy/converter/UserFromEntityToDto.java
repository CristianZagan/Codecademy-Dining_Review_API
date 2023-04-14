package com.portfolio.codecademy.converter;

import com.portfolio.codecademy.dto.UserDto;
import com.portfolio.codecademy.model.User;

public class UserFromEntityToDto {

    public static UserDto convertToDto(User user) {

        return UserDto.builder()
                .id(user.getId())
                .displayName(user.getDisplayName())
                .city(user.getCity())
                .state(user.getState())
                .zipCode(user.getZipcode())
                .peanutAllergyInterest(user.isPeanutAllergyInterest())
                .eggAllergyInterest(user.isEggAllergyInterest())
                .dairyAllergyInterest(user.isDairyAllergyInterest())
                .build();

//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setDisplayName(user.getDisplayName());
//        userDto.setCity(user.getCity());
//        userDto.setState(user.getState());
//        userDto.setZipCode(user.getZipcode());
//        userDto.setPeanutAllergyInterest(user.isPeanutAllergyInterest());
//        userDto.setEggAllergyInterest(user.isEggAllergyInterest());
//        userDto.setDairyAllergyInterest(user.isDairyAllergyInterest());
//        return userDto;
    }
 }
