package com.example.demo.service.reserva;

import com.example.demo.dto.ReservaDto;
import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.Usuario;
import com.example.demo.repository.reserva.ReservaRepository;
import com.example.demo.repository.usuario.UsuarioRepository;
import com.example.demo.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReserviceIm implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva findById(String id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    public Reserva save(Reserva reserva) {
        // Asigna la fecha de reserva si no se ha proporcionado
        reserva.setFechaReserva(Optional.ofNullable(reserva.getFechaReserva()).orElse(LocalDateTime.now()));
        // Guarda la reserva si el usuario existe, o lanza una excepción si no
        usuarioRepository.findById(reserva.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("El usuario con ID " + reserva.getUsuarioId() + " no existe."));
        return reservaRepository.save(reserva);

    }

    @Override
    public Reserva update(String id, Reserva reserva) {
        // Buscar la reserva existente por su ID
        Reserva existingReserva = reservaRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Reserva con ID " + id + " no encontrada.")
        );
        // Validar y actualizar el usuarioId si se ha proporcionado
        if (reserva.getUsuarioId() != null) {
            usuarioRepository.findById(reserva.getUsuarioId())
                    .orElseThrow(() -> new IllegalArgumentException("El usuario con ID " + reserva.getUsuarioId() + " no existe."));
            existingReserva.setUsuarioId(reserva.getUsuarioId());
        }
        // Actualizar otros campos si es necesario
        if (reserva.getFechaReserva() != null) {
            existingReserva.setFechaReserva(reserva.getFechaReserva());
        }
        // Guardar la reserva actualizada
        return reservaRepository.save(existingReserva);
    }

    @Override
    public void deltedById(String id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public ReservaDto getReservaById(String reservaId) {
        // Buscar la reserva por su identificador
        Optional<Reserva> reservaOpt = reservaRepository.findById(reservaId);
        if (reservaOpt.isPresent()) {
            Reserva reserva = reservaOpt.get();
            // Buscar el usuario por el usuarioId en la reserva
            Optional<Usuario> usuarioOpt = usuarioRepository.findById(reserva.getUsuarioId());
            if (usuarioOpt.isPresent()) {
                Usuario usuario = usuarioOpt.get();
                return new ReservaDto(reserva.getId(), usuario, reserva.getFechaReserva());
            } else {
                throw new IllegalArgumentException("Usuario no encontrado para la reserva que se a realizado.");
            }
        } else {
            throw new IllegalArgumentException("Reserva no encontrada en la DB.");
        }
    }
}
