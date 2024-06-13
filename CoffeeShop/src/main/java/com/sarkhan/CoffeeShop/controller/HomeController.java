package com.sarkhan.CoffeeShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; 


@Controller
public class HomeController {
@GetMapping(path="/home")
public String showHomePage() {
    return "home";
}
@GetMapping(path="/error")
public String showErrorPage() {
    return  "error";
}
}
