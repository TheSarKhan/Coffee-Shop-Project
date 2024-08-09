package com.sarkhan.CoffeeShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sarkhan.CoffeeShop.jpa.coffeeJPA.UserJPA;
import com.sarkhan.CoffeeShop.model.User;

@Service
public class UserService {

    @Autowired
    private UserJPA userJPA;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        if (userJPA.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userJPA.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userJPA.save(user);
    }
}
