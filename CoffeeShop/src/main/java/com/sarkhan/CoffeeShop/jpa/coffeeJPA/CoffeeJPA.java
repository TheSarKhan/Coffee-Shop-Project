 package com.sarkhan.CoffeeShop.jpa.coffeeJPA;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sarkhan.CoffeeShop.model.Coffee;

public interface CoffeeJPA extends JpaRepository<Coffee,Integer> {

 
}
