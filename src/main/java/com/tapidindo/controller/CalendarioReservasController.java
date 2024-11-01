package com.tapidindo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tapidindo.model.CalendarioReservas;
import com.tapidindo.repository.CalendarioReservasRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioReservasController {

    @Autowired
    private CalendarioReservasRepository calendarioReservasRepository;

    @GetMapping
    public List<CalendarioReservas> listarReservas() {
        return calendarioReservasRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CalendarioReservas> buscarReserva(@PathVariable Integer id) {
        return calendarioReservasRepository.findById(id);
    }

    @PostMapping
    public CalendarioReservas criarReserva(@RequestBody CalendarioReservas reserva) {
        return calendarioReservasRepository.save(reserva);
    }

    @DeleteMapping("/{id}")
    public void deletarReserva(@PathVariable Integer id) {
        calendarioReservasRepository.deleteById(id);
    }
}
