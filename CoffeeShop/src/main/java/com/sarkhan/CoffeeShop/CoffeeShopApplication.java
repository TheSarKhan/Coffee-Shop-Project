package com.sarkhan.CoffeeShop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean; 

import com.sarkhan.CoffeeShop.file.StorageProperties;
import com.sarkhan.CoffeeShop.file.StorageService;
@EnableConfigurationProperties(StorageProperties.class)
@SpringBootApplication
public class CoffeeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeShopApplication.class, args);
	}
	@Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {

            storageService.init();
        };
}
}