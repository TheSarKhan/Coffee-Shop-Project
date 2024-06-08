package com.sarkhan.CoffeeShop.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sarkhan.CoffeeShop.jpa.coffeeJPA.CoffeeJPA;
import com.sarkhan.CoffeeShop.model.Coffee;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(path="/coffeeTable")

public class CoffeeListRestController {
    @Autowired
   private CoffeeJPA coffeeJPA;
@GetMapping()
public List<Coffee> findAll(Model model){
  return coffeeJPA.findAll();
}

}
