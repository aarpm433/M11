package com.rocketFoodDelivery.rocketFood.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "street_address", nullable = false)
    private String street_address;

    @NotNull
    @Column(nullable = false)
    private String city;

    @NotNull
    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    @NotNull
    @CreationTimestamp
    private LocalDateTime createdOn;

    @NotNull
    @UpdateTimestamp
    private LocalDateTime updateOn;
}