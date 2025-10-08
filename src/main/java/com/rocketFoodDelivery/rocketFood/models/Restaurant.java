package com.rocketFoodDelivery.rocketFood.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relationship to User
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Relationship to Address
    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id", nullable = false, unique = true)
    private Address address;

    @NotBlank
    @Column(nullable = false)
    private String phone;

    @Column
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Min(1)
    @Max(3)
    @Column(name = "price_range", nullable = false, columnDefinition = "int default 1")
    private int priceRange = 1;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean active = true;
}