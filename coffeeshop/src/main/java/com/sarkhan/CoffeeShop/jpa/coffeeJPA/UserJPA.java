package com.sarkhan.CoffeeShop.jpa.coffeeJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarkhan.CoffeeShop.model.User;

public interface UserJPA extends JpaRepository<User, Integer> {
User findByUsername(String username);
User findByEmail(String email);
}
