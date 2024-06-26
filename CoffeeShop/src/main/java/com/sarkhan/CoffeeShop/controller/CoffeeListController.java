package com.sarkhan.CoffeeShop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarkhan.CoffeeShop.jpa.coffeeJPA.CoffeeJPA;
import com.sarkhan.CoffeeShop.model.Coffee;



@Controller
public class CoffeeListController {
    @Autowired
    private CoffeeJPA coffeeJPA;
    @GetMapping("/coffeelist")
    public String showCoffeeList(Model model) {
        List<Coffee> coffees = coffeeJPA.findAll();
        model.addAttribute("coffees", coffees);
        return "coffeelist";
    }
@GetMapping(path="/new-coffee")
public String showNewCoffeePage(Model model) {
    Coffee coffee=new Coffee();
    model.addAttribute(coffee);
    return "new-coffee";
}
 @PostMapping("/coffees/delete/{id}")
    public String deleteCoffee(@PathVariable("id") int id, Model model) {
        boolean coffeeExist = coffeeJPA.findById(id).isPresent();
       if (coffeeExist) {
        System.out.println(id);
        coffeeJPA.deleteById(id);
       }
            return "redirect:/coffeelist";
        
    }
@GetMapping("/coffees/update/{id}")
public String updateCoffee(@PathVariable("id") int id, @ModelAttribute("coffee") Coffee updatedCoffee, Model model) {
    
    Optional<Coffee> coffeeOptional = coffeeJPA.findById(id);
    boolean coffeeExist=coffeeOptional.isPresent();
    Coffee coffee=new Coffee();
  if (coffeeExist) {
    coffee=coffeeOptional.get();
  }
    model.addAttribute("coffee", coffee);
    return "new-coffee";  
}

}
