package com.tapidindo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventoController {
    @GetMapping("/eventos")
    public String listarEventos() {
        return "Listando eventos...";
    }
}
