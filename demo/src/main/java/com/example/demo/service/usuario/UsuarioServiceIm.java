package com.example.demo.service.usuario;


import com.example.demo.modelo.Usuario;
import com.example.demo.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceIm implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(String id, Usuario usuario){
        Usuario existeUs = usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuario no coincide con ninguno creado"));
    if (usuario.getEmail() != null){
        existeUs.setNombre(usuario.getEmail());
    }
    return usuarioRepository.save(existeUs);
    }

    @Override
    public void deleteById(String id){
        usuarioRepository.deleteById(id);
    }

}
