package com.example.demo.modelo;

//@Document ser realizo el modelo o tabla en mongoDBcompas para almacenar
//En este espacio se encuentran contructor vacio y con datos, getter and setter.

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collation = "reserva")
public class Reserva {

    @Id
    private String id;
    private String usuarioId;
    private LocalDateTime fechaReserva;

    public Reserva(){

    }

    public Reserva(String id, String usuarioId, LocalDateTime fechaReserva) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.fechaReserva = fechaReserva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}
