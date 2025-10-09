package com.rocketFoodDelivery.rocketFood.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

      @PrePersist
    public void prePersist() {
        this.createdOn = LocalDateTime.now();
        this.updateOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updateOn = LocalDateTime.now();
    }
}

