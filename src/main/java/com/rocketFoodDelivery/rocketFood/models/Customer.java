package com.rocketFoodDelivery.rocketFood.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    
    @OneToOne
    @JoinColumn(name = "user_id", unique = true , nullable = false)
    private UserEntity userEntity;


    @ManyToOne(cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "address_id" , nullable = false)
    private Address address;

    @NotNull
    @Column(columnDefinition = "boolean default true")
    private boolean active;

    @NotNull
    @Column(nullable = false)
    private String phone;

    @NotNull
    @Email
    @Column(nullable = false)
    private String email;

    @NotNull
    @CreationTimestamp
    private LocalDateTime createdOn;

    @NotNull
    @UpdateTimestamp
    private LocalDateTime updateOn;
}
