package com.tapidindo.controller;

import com.tapidindo.model.ContratacaoEvento;
import com.tapidindo.repository.ContratacaoEventoRepository;
import com.tapidindo.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contratacoes")
public class ContratacaoEventoController {

    @Autowired
    private ContratacaoEventoRepository contratacaoEventoRepository;

    // Método para listar todas as contratações
    @GetMapping
    public List<ContratacaoEvento> listarContratacoes() {
        return contratacaoEventoRepository.findAll();
    }

    // Método para obter uma contratação pelo id
    @GetMapping("/{id}")
    public Optional<ContratacaoEvento> buscarContratacao(@PathVariable Integer id) {
        return contratacaoEventoRepository.findById(id);
    }

    // Método para criar uma nova contratação
    @PostMapping
    public ContratacaoEvento criarContratacao(@RequestBody ContratacaoEvento contratacaoEvento) {
        return contratacaoEventoRepository.save(contratacaoEvento);
    }

    // Método para atualizar uma contratação existente
    @PutMapping("/{id}")
    public ContratacaoEvento atualizarContratacao(@PathVariable Integer id, @RequestBody ContratacaoEvento contratacaoAtualizada) {
        Optional<ContratacaoEvento> optionalContratacao = contratacaoEventoRepository.findById(id);
        if (optionalContratacao.isPresent()) {
            contratacaoAtualizada.setIdContratacao(id);
            return contratacaoEventoRepository.save(contratacaoAtualizada);
        } else {
            throw new ResourceNotFoundException("Contratação não encontrada com o id " + id);
        }
    }

    // Método para deletar uma contratação
    @DeleteMapping("/{id}")
    public void deletarContratacao(@PathVariable Integer id) {
        contratacaoEventoRepository.deleteById(id);
    }
}
