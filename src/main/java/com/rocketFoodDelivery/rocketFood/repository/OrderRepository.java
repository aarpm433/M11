package com.rocketFoodDelivery.rocketFood.repository;

import com.rocketFoodDelivery.rocketFood.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Find all orders by restaurant ID
    List<Order> findByRestaurantId(int restaurantId);

    // Find all orders by customer ID
    List<Order> findByCustomerId(int customerId);

    // Find all orders by order status
    List<Order> findByOrderStatusId(int orderStatusId);
}
