package com.rocketFoodDelivery.rocketFood.controller;

import com.rocketFoodDelivery.rocketFood.models.Restaurant;
import com.rocketFoodDelivery.rocketFood.models.UserEntity;
import com.rocketFoodDelivery.rocketFood.models.Address;
import com.rocketFoodDelivery.rocketFood.service.UserEntityService;
import com.rocketFoodDelivery.rocketFood.service.AddressService;
import com.rocketFoodDelivery.rocketFood.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/backoffice/restaurants")
public class RestaurantPageController {

    private final UserEntityService userService;
    private final AddressService addressService;
    private final RestaurantService restaurantService;

    // List all restaurants
    @GetMapping
    public String listRestaurants(Model model) {
        model.addAttribute("restaurants", restaurantService.findAll());
        return "restaurants-list"; // Thymeleaf template
    }

    // Show create restaurant form
    @GetMapping("/create")
    public String createRestaurantForm(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("addresses", addressService.findAll());
        return "restaurants-create"; // Thymeleaf template
    }

    // Show edit restaurant form
    @GetMapping("/{id}/edit")
    public String editRestaurantForm(@PathVariable int id, Model model) {
        Restaurant restaurant = restaurantService.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("users", userService.findAll());
        model.addAttribute("addresses", addressService.findAll());
        return "restaurants-edit"; // Thymeleaf template
    }

    // Optional: handle form submission directly (if not using REST API)
    @PostMapping
    public String saveRestaurant(@ModelAttribute Restaurant restaurant) {
        restaurantService.saveRestaurant(restaurant);
        return "redirect:/backoffice/restaurants";
    }
}
