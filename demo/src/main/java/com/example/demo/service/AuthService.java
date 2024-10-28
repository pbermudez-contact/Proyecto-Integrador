package com.example.demo.service;

import com.example.demo.modelo.Usuario;
import com.example.demo.repository.usuario.UsuarioRepository;
import com.example.demo.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String login(String email, String password){
        if (email == null || password == null){
            throw new RuntimeException("Invalid credentials");
        }

        Usuario usuario = usuarioRepository.findByEmail(email);

        if(usuario != null && passwordEncoder.matches(password, usuario.getPassword())){
            System.out.println(usuario);
            return  jwtTokenUtil.generateToken(usuario.getId());
    } else {
            throw new RuntimeException("Credenciales Invalidas");
        }
    }
}
