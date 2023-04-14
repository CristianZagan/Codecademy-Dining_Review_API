package com.portfolio.codecademy.converter;

import com.portfolio.codecademy.dto.UserDto;
import com.portfolio.codecademy.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserFromDtoToEntity {

    public static User convertToEntity(UserDto userDto) {

        return User.builder()
                .id(userDto.getId())
                .displayName(userDto.getDisplayName())
                .city(userDto.getCity())
                .state(userDto.getState())
                .zipcode(userDto.getZipCode())
                .peanutAllergyInterest(userDto.isPeanutAllergyInterest())
                .eggAllergyInterest(userDto.isEggAllergyInterest())
                .dairyAllergyInterest(userDto.isDairyAllergyInterest())
                .build();
    }
}
