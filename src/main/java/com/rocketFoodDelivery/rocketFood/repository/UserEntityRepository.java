package com.rocketFoodDelivery.rocketFood.repository;

import com.rocketFoodDelivery.rocketFood.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    // Find a user by email (useful for login)
    Optional<UserEntity> findByEmail(String email);

    // Check if an email already exists
    boolean existsByEmail(String email);
}
