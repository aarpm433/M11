package com.rocketFoodDelivery.rocketFood.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", unique = true)
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
    @Column(name = "price_range", nullable = false)
    private int priceRange = 1;

    @Column(nullable = false)
    private boolean active = true;

    @Column(name = "created_on", nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;


        @PrePersist
            protected void onCreate() {
                if (createdOn == null) createdOn = LocalDateTime.now();
                if (updatedOn == null) updatedOn = LocalDateTime.now();
            }

            @PreUpdate
            protected void onUpdate() {
                updatedOn = LocalDateTime.now();
        }
}
