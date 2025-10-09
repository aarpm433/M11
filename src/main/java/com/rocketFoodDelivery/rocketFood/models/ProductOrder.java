package com.rocketFoodDelivery.rocketFood.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "product_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "product_id", nullable = false)
    private int productId;

    @NotNull
    @Column(name = "order_id", nullable = false)
    private int orderId;

    @NotNull
    @Min(1)
    @Column(name = "product_quantity", nullable = false)
    private int productQuantity;

    @NotNull
    @Min(0)
    @Column(name = "product_unit_cost", nullable = false)
    private int productUnitCost;
}
