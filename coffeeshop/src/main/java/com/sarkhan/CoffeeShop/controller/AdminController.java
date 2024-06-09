package com.sarkhan.CoffeeShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
@GetMapping(path="/admin")
public String showAdminPage() {
    return "admin";
}

}
