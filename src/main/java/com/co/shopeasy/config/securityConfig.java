package com.co.shopeasy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuración básica: deshabilita CSRF (ajusta según necesites),
        // permite acceso público a /public/** y exige autenticación al resto.
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(); // o .formLogin() si prefieres login por formulario

        return http.build();
    }
}
