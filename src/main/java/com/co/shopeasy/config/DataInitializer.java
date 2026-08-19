package com.co.shopeasy.config;

import com.co.shopeasy.entity.Usuario;
import com.co.shopeasy.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner inicializarUsuarios(
            UsuarioRepository repository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            if (!repository.existsByUsername("admin")) {

                Usuario admin = new Usuario();

                admin.setUsername("admin");

                admin.setPassword(
                        passwordEncoder.encode("123456")
                );

                admin.setRol("ADMIN");

                admin.setActivo(true);

                repository.save(admin);

                System.out.println(
                        "=================================="
                );

                System.out.println(
                        "Usuario administrador creado"
                );

                System.out.println(
                        "Usuario: admin"
                );

                System.out.println(
                        "Contraseña: 123456"
                );

                System.out.println(
                        "=================================="
                );
            }
        };
    }
}