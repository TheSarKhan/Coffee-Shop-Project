package com.sarkhan.CoffeeShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarkhan.CoffeeShop.jpa.coffeeJPA.UserJPA;
import com.sarkhan.CoffeeShop.model.User;
import com.sarkhan.CoffeeShop.service.UserService;
 
 




@Controller
public class AuthorizeController { 
 
    @Autowired
    private UserJPA userJPA;
    @Autowired
    private UserService userService;
    @GetMapping(path="/register")
public String redirectRegisterPage(Model model) {
    model.addAttribute("user",new User());
    return "register";
}
@GetMapping(path="/login")
public String showLoginPage(Model model, User user) {
    model.addAttribute("user",user);
    return "login";
}
@PostMapping("/register")
    public String registerUser(User user, Model model) {
        try {
            userService.registerUser(user);
            return "redirect:/login"; // Başarıyla kayıt olunduysa login sayfasına yönlendir
        } catch (IllegalArgumentException e) {
            model.addAttribute("user", user);
            model.addAttribute("error", e.getMessage()); // Hata mesajını modelde taşı
            return "register"; // Aynı sayfayı tekrar göster
        }
    }

 

}
