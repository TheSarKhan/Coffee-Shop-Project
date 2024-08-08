package com.sarkhan.CoffeeShop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String username;
private String email;
private String password;
private int enabled;

public String getPassword(){
    return password ;
}
public void setPassword(String password){
    this.password=password;
}
}
