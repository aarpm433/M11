package com.rocketFoodDelivery.rocketFood.service;

import com.rocketFoodDelivery.rocketFood.models.UserEntity;
import com.rocketFoodDelivery.rocketFood.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserEntityService {

    private final UserEntityRepository userRepository;

    // Fetch all users for the backoffice page
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    public Optional<UserEntity> findById(int id) {
        return userRepository.findById(id);
    }
}
