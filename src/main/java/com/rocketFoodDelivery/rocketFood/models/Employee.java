package com.rocketFoodDelivery.rocketFood.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "user_id", nullable = false)
    private String userId;

    @NotBlank
    @Column(nullable = false)
    private String city;

    @NotBlank
    @Column(name = "postal_code", nullable = false)
    private String postalCode;
}
