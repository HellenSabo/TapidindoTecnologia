package com.tapidindo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tapidindo.model.Evento;
import com.tapidindo.repository.EventoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    // Método para listar todos os eventos
    @GetMapping
    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    // Método para obter um evento por ID
    @GetMapping("/{id}")
    public Optional<Evento> buscarEvento(@PathVariable Integer id) {
        return eventoRepository.findById(id);
    }

    // Método para criar um novo evento
    @PostMapping
    public Evento criarEvento(@RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }

    // Método para atualizar um evento existente
    @PutMapping("/{id}")
    public Evento atualizarEvento(@PathVariable Integer id, @RequestBody Evento eventoAtualizado) {
        eventoAtualizado.setId(id);
        return eventoRepository.save(eventoAtualizado);
    }

    // Método para deletar um evento
    @DeleteMapping("/{id}")
    public void deletarEvento(@PathVariable Integer id) {
        eventoRepository.deleteById(id);
    }
}
