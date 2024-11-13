package com.tapidindo.controller;

import com.tapidindo.model.CalendarioReservas;
import com.tapidindo.repository.CalendarioReservasRepository;
import com.tapidindo.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioReservasController {

    @Autowired
    private CalendarioReservasRepository calendarioReservasRepository;

    // Método para listar todas as reservas
    @GetMapping
    public List<CalendarioReservas> listarReservas() {
        return calendarioReservasRepository.findAll();
    }

    // Método para obter uma reserva pelo id
    @GetMapping("/{id}")
    public Optional<CalendarioReservas> buscarReserva(@PathVariable Integer id) {
        return calendarioReservasRepository.findById(id);
    }

    // Método para criar uma nova reserva
    @PostMapping
    public CalendarioReservas criarReserva(@RequestBody CalendarioReservas reserva) {
        return calendarioReservasRepository.save(reserva);
    }

    // Método para atualizar uma reserva existente
    @PutMapping("/{id}")
    public ResponseEntity<CalendarioReservas> atualizarReserva(@PathVariable Integer id, @RequestBody CalendarioReservas reservaDetails) {
        CalendarioReservas reserva = calendarioReservasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrada com id " + id));

        reserva.setDataEvento(reservaDetails.getDataEvento());
        reserva.setStatus(reservaDetails.getStatus());
        reserva.setEvento(reservaDetails.getEvento());

        CalendarioReservas reservaAtualizada = calendarioReservasRepository.save(reserva);
        return ResponseEntity.ok(reservaAtualizada);
    }
    
    // Método para atualizar uma reserva existente
    @DeleteMapping("/{id}")
    public void deletarReserva(@PathVariable Integer id) {
        calendarioReservasRepository.deleteById(id);
    }
}
