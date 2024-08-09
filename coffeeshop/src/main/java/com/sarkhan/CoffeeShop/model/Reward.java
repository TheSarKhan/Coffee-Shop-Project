package com.sarkhan.CoffeeShop.model;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="rewards")
public class Reward {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
public int id;
public String rewardname;
public int beancount;
private String image;
@Override
public String toString() {
    return "Reward [id=" + id + ", rewardname=" + rewardname + ", beancount=" + beancount + ", image=" + image + "]";
}
}
