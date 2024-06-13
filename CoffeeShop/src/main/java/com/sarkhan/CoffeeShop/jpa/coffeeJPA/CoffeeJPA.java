 package com.sarkhan.CoffeeShop.jpa.coffeeJPA;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarkhan.CoffeeShop.model.Coffee;

public interface CoffeeJPA extends JpaRepository<Coffee,Integer> {
    Optional<Coffee> findByName(String name);
 
}
