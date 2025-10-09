package com.rocketFoodDelivery.rocketFood.service;

import com.rocketFoodDelivery.rocketFood.models.Restaurant;
import com.rocketFoodDelivery.rocketFood.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    // Find all restaurants
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    // Find by ID
    public Optional<Restaurant> findById(int id) {
        return restaurantRepository.findById(id);
    }

    // Save or update restaurant
    public Restaurant saveRestaurant(Restaurant restaurant) {
        // Ensure the restaurant has a valid address
        if (restaurant.getAddress() == null) {
            throw new RuntimeException("Restaurant must have an address");
        }

        // CascadeType.ALL ensures address is saved automatically
        return restaurantRepository.save(restaurant);
    }

    // Delete by ID
    public void deleteById(int id) {
        restaurantRepository.deleteById(id);
    }
}
