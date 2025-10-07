package com.rocketFoodDelivery.rocketFood.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "restaurant_id", nullable = false)
    private int restaurantId;

    @NotNull
    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @NotNull
    @Column(name = "order_status_id", nullable = false)
    private int orderStatusId;

    @Min(1)
    @Max(5)
    @Column(name = "restaurant_rating")
    private Integer restaurantRating;
}
