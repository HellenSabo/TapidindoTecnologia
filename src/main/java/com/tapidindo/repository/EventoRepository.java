package com.tapidindo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tapidindo.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {}
