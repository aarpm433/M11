package com.rocketFoodDelivery.rocketFood.repository;

import com.rocketFoodDelivery.rocketFood.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Find employee by their User
    Optional<Employee> findByUserId(int userId);

    // You can add other custom queries, e.g.,
    // List<Employee> findByAddressCity(String city);
}
