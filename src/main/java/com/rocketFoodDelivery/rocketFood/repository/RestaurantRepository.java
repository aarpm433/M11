package com.rocketFoodDelivery.rocketFood.repository;

import com.rocketFoodDelivery.rocketFood.models.Restaurant;
import com.rocketFoodDelivery.rocketFood.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    // Find restaurants by user
    Optional<Restaurant> findByUser(User user);

    // Find restaurants by active status
    List<Restaurant> findByActive(boolean active);

    // Optional: find by name containing keyword
    List<Restaurant> findByNameContainingIgnoreCase(String keyword);
}
