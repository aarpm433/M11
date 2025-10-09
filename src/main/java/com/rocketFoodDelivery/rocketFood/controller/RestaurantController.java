package com.rocketFoodDelivery.rocketFood.controller;

import com.rocketFoodDelivery.rocketFood.models.Address;
import com.rocketFoodDelivery.rocketFood.models.Restaurant;
import com.rocketFoodDelivery.rocketFood.service.AddressService;
import com.rocketFoodDelivery.rocketFood.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final AddressService addressService;

    @GetMapping
    public String listRestaurants(@RequestParam(value = "q", required = false) String query, Model model) {
        List<Restaurant> restaurants = (query != null && !query.isEmpty())
                ? restaurantService.searchByName(query)
                : restaurantService.findAll();

        List<Address> addresses = addressService.findAll();

        // Ensure a non-null address for the form
        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setAddress(new Address());

        model.addAttribute("restaurants", restaurants);
        model.addAttribute("restaurant", newRestaurant);
        model.addAttribute("addresses", addresses);
        return "restaurants";
    }

    @GetMapping("/{id}/edit")
    public String editRestaurant(@PathVariable int id, Model model) {
        Restaurant r = restaurantService.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        if (r.getAddress() == null) {
            r.setAddress(new Address());
        }

        List<Address> addresses = addressService.findAll();
        model.addAttribute("restaurant", r);
        model.addAttribute("restaurants", restaurantService.findAll());
        model.addAttribute("addresses", addresses);
        return "restaurants";
    }

    @PostMapping
    public String saveRestaurant(@ModelAttribute Restaurant restaurant) {
        // Fetch the full Address object using selected ID
        if (restaurant.getAddress() != null && restaurant.getAddress().getId() != 0) {
            Address fullAddress = addressService.findById(restaurant.getAddress().getId())
                    .orElseThrow(() -> new RuntimeException("Address not found"));
            restaurant.setAddress(fullAddress);
        }

        restaurantService.saveRestaurant(restaurant);
        return "redirect:/restaurants";
    }

    @PostMapping("/{id}/delete")
    public String deleteRestaurant(@PathVariable int id) {
        restaurantService.deleteById(id);
        return "redirect:/restaurants";
    }
}
