package com.sarkhan.CoffeeShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
@GetMapping(path="/home")
public String showHomePage() {
    return "home";
}

}
