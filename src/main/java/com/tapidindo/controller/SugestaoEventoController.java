package com.tapidindo.controller;

import com.tapidindo.model.SugestaoEvento;
import com.tapidindo.repository.SugestaoEventoRepository;
import com.tapidindo.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sugestoes")
public class SugestaoEventoController {

    @Autowired
    private SugestaoEventoRepository sugestaoEventoRepository;

    // Método para listar todas as sugestões
    @GetMapping
    public List<SugestaoEvento> listarSugestoes() {
        return sugestaoEventoRepository.findAll();
    }

    // Método para obter uma sugestão pelo id
    @GetMapping("/{id}")
    public Optional<SugestaoEvento> buscarSugestao(@PathVariable Integer id) {
        return sugestaoEventoRepository.findById(id);
    }

    // Método para criar uma nova sugestão
    @PostMapping
    public SugestaoEvento criarSugestao(@RequestBody SugestaoEvento sugestaoEvento) {
        return sugestaoEventoRepository.save(sugestaoEvento);
    }

    // Método para atualizar uma sugestão existente
    @PutMapping("/{id}")
    public ResponseEntity<SugestaoEvento> atualizarSugestao(@PathVariable Integer id, @RequestBody SugestaoEvento sugestaoDetails) {
        SugestaoEvento sugestao = sugestaoEventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sugestão não encontrada com id " + id));

        sugestao.setDescricao(sugestaoDetails.getDescricao());
        sugestao.setUsuarioId(sugestaoDetails.getUsuarioId());

        SugestaoEvento sugestaoAtualizada = sugestaoEventoRepository.save(sugestao);
        return ResponseEntity.ok(sugestaoAtualizada);
    }
    
    // Método para deletar uma sugestão
    @DeleteMapping("/{id}")
    public void deletarSugestao(@PathVariable Integer id) {
        sugestaoEventoRepository.deleteById(id);
    }
}
