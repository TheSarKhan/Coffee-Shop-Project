package com.sarkhan.CoffeeShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; 

import com.sarkhan.CoffeeShop.jpa.coffeeJPA.CoffeeJPA;
import com.sarkhan.CoffeeShop.model.Coffee;

 

@Controller
public class HomeController {
    @Autowired
    private CoffeeJPA coffeeJPA;
@GetMapping(path="/home")
public String showHomePage(Model model) {
    List<Coffee> coffees=coffeeJPA.findAll();
 model.addAttribute("coffees",coffees);
    return "home";
}
@GetMapping(path="/error")
public String showErrorPage() {
    return  "error";
}
}
