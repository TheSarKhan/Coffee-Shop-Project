package com.sarkhan.CoffeeShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sarkhan.CoffeeShop.jpa.coffeeJPA.RewardJPA; 
import com.sarkhan.CoffeeShop.model.Reward;
 


@Controller
public class RewardsController {
    @Autowired
    private RewardJPA rewardJPA;
@GetMapping("/rewards")
public String showRewardsPage(Model model) {
    List<Reward> rewards = rewardJPA.findAll();
    model.addAttribute("rewards", rewards);
    return "rewards";
}
@GetMapping("/new-reward")
public String showNewRewardPage(Model model) {
    Reward reward=new Reward();
    model.addAttribute(reward);
    return "new-reward";
}

    @GetMapping("/rewardlist")
    public String showRewardList(Model model) {
        List<Reward> rewards = rewardJPA.findAll();
 
        model.addAttribute("rewards", rewards);
        return "rewardlist";
    }
    
}
