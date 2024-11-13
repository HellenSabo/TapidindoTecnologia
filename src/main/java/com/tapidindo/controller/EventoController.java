package com.tapidindo.controller;

import com.tapidindo.model.Evento;
import com.tapidindo.repository.EventoRepository;
import com.tapidindo.exception.ResourceNotFoundException; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    // Método para criar um novo evento
    @PostMapping
    public Evento createEvento(@RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }

    // Método para listar todos os eventos
    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    // Método para obter um evento pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Integer id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id " + id));
        return ResponseEntity.ok(evento);
    }

    // Método para atualizar um evento existente
    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable Integer id, @RequestBody Evento eventoDetails) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id " + id));

        evento.setTitulo(eventoDetails.getTitulo());
        evento.setDescricao(eventoDetails.getDescricao());
        evento.setDataEvento(eventoDetails.getDataEvento());
        evento.setLocalidade(eventoDetails.getLocalidade());

        Evento updatedEvento = eventoRepository.save(evento);
        return ResponseEntity.ok(updatedEvento);
    }

    // Método para deletar um evento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Integer id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id " + id));

        eventoRepository.delete(evento);
        return ResponseEntity.noContent().build();
    }
}
