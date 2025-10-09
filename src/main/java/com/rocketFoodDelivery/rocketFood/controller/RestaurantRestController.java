package com.rocketFoodDelivery.rocketFood.controller;

import com.rocketFoodDelivery.rocketFood.models.Restaurant;
import com.rocketFoodDelivery.rocketFood.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantRestController {

    private final RestaurantService restaurantService;

    // CREATE
    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.saveRestaurant(restaurant);
    }

    // READ ALL
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable int id) {
        return restaurantService.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable int id, @RequestBody Restaurant updatedRestaurant) {
        Restaurant restaurant = restaurantService.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        restaurant.setName(updatedRestaurant.getName());
        restaurant.setPhone(updatedRestaurant.getPhone());
        restaurant.setEmail(updatedRestaurant.getEmail());
        restaurant.setPriceRange(updatedRestaurant.getPriceRange());
        restaurant.setActive(updatedRestaurant.isActive());

        return restaurantService.saveRestaurant(restaurant);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable int id) {
        restaurantService.deleteById(id);
    }
}
