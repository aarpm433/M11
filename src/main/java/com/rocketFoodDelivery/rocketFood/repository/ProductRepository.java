package com.rocketFoodDelivery.rocketFood.repository;

import com.rocketFoodDelivery.rocketFood.models.Product;
import com.rocketFoodDelivery.rocketFood.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Find all products for a given restaurant
    List<Product> findByRestaurant(Restaurant restaurant);

    // Optional: Find all products by name containing a keyword
    List<Product> findByNameContainingIgnoreCase(String keyword);
}
