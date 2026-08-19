package com.co.shopeasy.service;

import com.co.shopeasy.entity.Usuario;
import com.co.shopeasy.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario crearUsuario(
            String username,
            String password,
            String rol) {

        if (usuarioRepository.existsByUsername(username)) {
            throw new RuntimeException(
                    "El usuario ya existe."
            );
        }

        String passwordEncriptada =
                passwordEncoder.encode(password);

        Usuario usuario = new Usuario();

        usuario.setUsername(username);
        usuario.setPassword(passwordEncriptada);
        usuario.setRol(rol);
        usuario.setActivo(true);

        return usuarioRepository.save(usuario);
    }
}