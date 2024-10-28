package com.example.demo.controller.reserva;


import com.example.demo.dto.ReservaDto;
import com.example.demo.modelo.Reserva;
import com.example.demo.service.reserva.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// se crea el controlador para reservas, Implementa el controlador y servicio de tu API REST.
@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> findAll() {
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDto> getReservaById(@PathVariable String id) {
        try {
            ReservaDto reservaDto = reservaService.getReservaById(id);
            return ResponseEntity.ok(reservaDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Reserva> save(@RequestBody Reserva reserva){
        try {
            Reserva nuevaReserva = reservaService.save(reserva);
            return ResponseEntity.ok(nuevaReserva);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PutMapping
    public ResponseEntity<Reserva> update(@PathVariable String idReserva, @RequestBody Reserva reserva) {
        Reserva actualizarReserva = reservaService.update(idReserva, reserva);
        return ResponseEntity.ok(actualizarReserva);
    }


    @DeleteMapping("/{idReserva}")
    public void deleteById(@PathVariable String idReversa){
        reservaService.deltedById(idReversa);
    }
}
