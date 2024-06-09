package com.sarkhan.CoffeeShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarkhan.CoffeeShop.jpa.coffeeJPA.CoffeeJPA;
import com.sarkhan.CoffeeShop.model.Coffee;

@Controller
public class AdminController {
    @Autowired
    private CoffeeJPA coffeeJPA;

    @GetMapping(path = "/admin")
    public String showAdminPage(Model model) {
        model.addAttribute("coffee", new Coffee());
        return "admin";
    }

    @PostMapping("/addcoffee")
    public String addCoffee(@ModelAttribute Coffee coffee) {
        coffeeJPA.save(coffee);
        return "redirect:/coffeelist";
    }


}
