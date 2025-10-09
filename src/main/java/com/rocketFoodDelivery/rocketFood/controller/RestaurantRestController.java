// ...existing code...
package com.rocketFoodDelivery.rocketFood.controller;

import com.rocketFoodDelivery.rocketFood.models.Restaurant;
import com.rocketFoodDelivery.rocketFood.models.UserEntity;
import com.rocketFoodDelivery.rocketFood.models.Address;
import com.rocketFoodDelivery.rocketFood.service.RestaurantService;
import com.rocketFoodDelivery.rocketFood.service.UserEntityService;
import com.rocketFoodDelivery.rocketFood.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
// ...existing code...

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantRestController {

    private final RestaurantService restaurantService;
    private final UserEntityService userService;
    private final AddressService addressService;

    // GET all restaurants
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.findAll();
    }

    // GET one restaurant by ID
    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable int id) {
        return restaurantService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found"));
    }

    // CREATE a new restaurant
    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {

        // --- USER ---
        if (restaurant.getUser() != null && restaurant.getUser().getId() != 0) {
            UserEntity user = userService.findById(restaurant.getUser().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
            restaurant.setUser(user);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User ID must be provided");
        }

        // --- ADDRESS ---
        if (restaurant.getAddress() != null) {
            Address address = restaurant.getAddress();
            // new address will be saved automatically because of CascadeType.ALL
            restaurant.setAddress(address);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Address must be provided");
        }

        // --- SAVE RESTAURANT ---
        return restaurantService.saveRestaurant(restaurant);
    }

    // UPDATE existing restaurant
    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable int id, @RequestBody Restaurant updatedRestaurant) {
        Restaurant restaurant = restaurantService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found"));

        // Update basic fields
        restaurant.setName(updatedRestaurant.getName());
        restaurant.setPhone(updatedRestaurant.getPhone());
        restaurant.setEmail(updatedRestaurant.getEmail());
        restaurant.setPriceRange(updatedRestaurant.getPriceRange());
        restaurant.setActive(updatedRestaurant.isActive());

        // Update user if provided
        if (updatedRestaurant.getUser() != null && updatedRestaurant.getUser().getId() != 0) {
            UserEntity user = userService.findById(updatedRestaurant.getUser().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
            restaurant.setUser(user);
        }

        // Update address if provided
        if (updatedRestaurant.getAddress() != null) {
            Address address = updatedRestaurant.getAddress();
            restaurant.setAddress(address);
        }

        return restaurantService.saveRestaurant(restaurant);
    }

    // DELETE a restaurant
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable int id) {
        restaurantService.deleteById(id);
    }
}
// ...existing code...