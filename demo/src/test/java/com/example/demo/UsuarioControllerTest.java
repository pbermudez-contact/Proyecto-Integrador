package com.example.demo;

import com.example.demo.controller.usuario.UsuarioController;
import com.example.demo.modelo.Usuario;
import com.example.demo.service.usuario.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario(); // Asumiendo que tienes un constructor por defecto
        usuario.setNombre("Test User");
        usuario.setEmail("test@example.com");
    }

    @Test
    void findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario);

        when(usuarioService.findAll()).thenReturn(usuarios);

        List<Usuario> result = usuarioController.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(usuario.getNombre(), result.get(0).getNombre());
        verify(usuarioService, times(1)).findAll();
    }

    @Test
    void findById() {
        when(usuarioService.findById(any(String.class))).thenReturn(usuario);

        Usuario result = usuarioController.findById("1");

        assertNotNull(result);
        assertEquals(usuario.getNombre(), result.getNombre());
        verify(usuarioService, times(1)).findById("1");
    }

    @Test
    void save() {
        when(usuarioService.save(any(Usuario.class))).thenReturn(usuario);

        Usuario result = usuarioController.save(usuario);

        assertNotNull(result);
        assertEquals(usuario.getNombre(), result.getNombre());
        verify(usuarioService, times(1)).save(usuario);
    }

    @Test
    void update() {
        when(usuarioService.update(any(String.class), any(Usuario.class))).thenReturn(usuario);

        Usuario result = usuarioController.update("1", usuario);

        assertNotNull(result);
        assertEquals(usuario.getNombre(), result.getNombre());
        verify(usuarioService, times(1)).update("1", usuario);
    }

    @Test
    void deleteById() {
        doNothing().when(usuarioService).deleteById(any(String.class));

        usuarioController.deletedById("1");

        verify(usuarioService, times(1)).deleteById("1");
    }
}
