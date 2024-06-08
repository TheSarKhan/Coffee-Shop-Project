package com.sarkhan.CoffeeShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sarkhan.CoffeeShop.jpa.coffeeJPA.CoffeeJPA;
import com.sarkhan.CoffeeShop.model.Coffee;



@Controller
public class CoffeeListController {
    @Autowired
    private CoffeeJPA coffeeJPA;
@GetMapping(path="/coffeelist")
public String showCoffeeList(Model model) {
     List<Coffee> coffees=coffeeJPA.findAll();
     model.addAttribute("coffees",coffees);
    return "coffeelist";
}

}
