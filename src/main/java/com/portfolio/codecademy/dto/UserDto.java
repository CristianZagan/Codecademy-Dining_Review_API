package com.portfolio.codecademy.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String displayName;
    private String city;
    private String state;
    private String zipCode;
    private boolean peanutAllergyInterest;
    private boolean eggAllergyInterest;
    private boolean dairyAllergyInterest;
}
