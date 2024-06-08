package com.sarkhan.CoffeeShop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarkhan.CoffeeShop.jpa.coffeeJPA.CoffeeJPA;
import com.sarkhan.CoffeeShop.model.Coffee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/coffees")
public class CoffeeRestController {
    @Autowired
   private CoffeeJPA coffeeJPA;
@GetMapping()
public List<Coffee> findAll(){
  return coffeeJPA.findAll();
}
@GetMapping(path = "/{id}")
public Coffee findById(@PathVariable(name="id")Integer id){
  return coffeeJPA.findById(id).get();
}
}
