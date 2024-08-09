package com.sarkhan.CoffeeShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sarkhan.CoffeeShop.file.StorageService;
import com.sarkhan.CoffeeShop.jpa.coffeeJPA.CoffeeJPA;
import com.sarkhan.CoffeeShop.jpa.coffeeJPA.RewardJPA;
import com.sarkhan.CoffeeShop.model.Coffee;
import com.sarkhan.CoffeeShop.model.Reward;

@Controller
public class AdminController {
    @Autowired
    private CoffeeJPA coffeeJPA;
    @Autowired
    private  RewardJPA rewardJPA;
@Autowired
private StorageService storageService;
    @GetMapping(path = "/admin")
    public String showAdminPage(Model model) {
        model.addAttribute("coffee", new Coffee());
        return "admin";
    }

    @PostMapping("/addcoffee")
    public String addCoffee(@ModelAttribute Coffee coffee, @RequestParam("file") MultipartFile file) {
        String filename = storageService.store(file);
        coffee.setImage(filename);
        coffeeJPA.save(coffee);
        return "redirect:/coffeelist";
    }
    @PostMapping("/addReward")
    public String addReward(@ModelAttribute Reward reward, @RequestParam("file") MultipartFile file) {
        String filename = storageService.store(file);
        reward.setImage(filename);
        rewardJPA.save(reward);
        return "redirect:/rewardlist";
    }
}
