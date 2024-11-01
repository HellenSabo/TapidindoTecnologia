package com.tapidindo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tapidindo.model.ContratacaoEvento;
import com.tapidindo.repository.ContratacaoEventoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contratacoes")
public class ContratacaoEventoController {

    @Autowired
    private ContratacaoEventoRepository contratacaoEventoRepository;

    @GetMapping
    public List<ContratacaoEvento> listarContratacoes() {
        return contratacaoEventoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ContratacaoEvento> buscarContratacao(@PathVariable Integer id) {
        return contratacaoEventoRepository.findById(id);
    }

    @PostMapping
    public ContratacaoEvento criarContratacao(@RequestBody ContratacaoEvento contratacaoEvento) {
        return contratacaoEventoRepository.save(contratacaoEvento);
    }

    @PutMapping("/{id}")
    public ContratacaoEvento atualizarContratacao(@PathVariable Integer id, @RequestBody ContratacaoEvento contratacaoAtualizada) {
        contratacaoAtualizada.setId(id);
        return contratacaoEventoRepository.save(contratacaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarContratacao(@PathVariable Integer id) {
        contratacaoEventoRepository.deleteById(id);
    }
}
