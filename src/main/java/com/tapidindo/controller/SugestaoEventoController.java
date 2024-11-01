package com.tapidindo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tapidindo.model.SugestaoEvento;
import com.tapidindo.repository.SugestaoEventoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sugestoes")
public class SugestaoEventoController {

    @Autowired
    private SugestaoEventoRepository sugestaoEventoRepository;

    @GetMapping
    public List<SugestaoEvento> listarSugestoes() {
        return sugestaoEventoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<SugestaoEvento> buscarSugestao(@PathVariable Integer id) {
        return sugestaoEventoRepository.findById(id);
    }

    @PostMapping
    public SugestaoEvento criarSugestao(@RequestBody SugestaoEvento sugestaoEvento) {
        return sugestaoEventoRepository.save(sugestaoEvento);
    }

    @DeleteMapping("/{id}")
    public void deletarSugestao(@PathVariable Integer id) {
        sugestaoEventoRepository.deleteById(id);
    }
}
