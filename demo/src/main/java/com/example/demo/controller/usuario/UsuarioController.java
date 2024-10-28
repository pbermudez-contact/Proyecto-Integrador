package com.example.demo.controller.usuario;


import com.example.demo.modelo.Usuario;
import com.example.demo.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{idUsuario}")
    public Usuario findById(@PathVariable String idUsuario) {
        return usuarioService.findById(idUsuario);
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{idUsuario}")
    public Usuario update(@PathVariable String idUsuario,@RequestBody Usuario usuario){
        return usuarioService.update(idUsuario, usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public void deletedById(@PathVariable String idUsuario){
        usuarioService.deleteById(idUsuario);
    }


}
