package com.sarkhan.CoffeeShop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login", "/register","/" , "/images/**", "/styles/**" ,"/error", "/home", "/menu", "/navbar").permitAll() // İzin verilen sayfalar
                .requestMatchers("/static/**").permitAll() // Statik dosyalara izin ver
                .anyRequest().authenticated() // Diğer sayfalar için kimlik doğrulama gerekli
            )
            .formLogin(form -> form
                .loginPage("/login") // Özel login sayfası
                .defaultSuccessUrl("/", true) // Başarılı giriş sonrası ana sayfaya yönlendir
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout") // Başarılı çıkış sonrası login sayfasına yönlendir
                .permitAll()
            )
            .csrf().disable(); // CSRF korumasını devre dışı bırakın, ancak sadece geliştirme sırasında
        return http.build();
    }
}
