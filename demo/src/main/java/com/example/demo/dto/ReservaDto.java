package com.example.demo.dto;

import com.example.demo.modelo.Usuario;
import java.time.LocalDateTime;

public class ReservaDto {
    private String id;
    private Usuario usuario;
    private LocalDateTime fechaReserva;

    public ReservaDto(String id, Usuario usuario, LocalDateTime fechaReserva) {
        this.id = id;
        this.usuario = usuario;
        this.fechaReserva = fechaReserva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}

