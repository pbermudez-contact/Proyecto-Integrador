package com.example.demo.service.reserva;

import com.example.demo.dto.ReservaDto;
import com.example.demo.modelo.Reserva;

import java.util.List;

public interface ReservaService {
    List<Reserva> findAll();
    Reserva findById(String id);
    Reserva save(Reserva reserva);
    Reserva update(String id, Reserva reserva);
    void deltedById(String id);
    ReservaDto getReservaById(String reservaId);
}
