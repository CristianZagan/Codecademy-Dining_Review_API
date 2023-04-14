package com.portfolio.codecademy.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "`USER`")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String displayName;
    private String city;
    private String state;
    private String zipcode;
    private boolean peanutAllergyInterest;
    private boolean eggAllergyInterest;
    private boolean dairyAllergyInterest;
}
