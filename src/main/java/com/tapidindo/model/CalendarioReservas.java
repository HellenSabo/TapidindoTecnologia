package com.tapidindo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "calendario_reservas")
public class CalendarioReservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalendario;

    @Column(nullable = false)
    private Date dataEvento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCalendario status;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    // Construtores
    public CalendarioReservas() {}

    public CalendarioReservas(Date dataEvento, StatusCalendario status, Evento evento) {
        this.dataEvento = dataEvento;
        this.status = status;
        this.evento = evento;
    }

    // Getters e Setters
    public Integer getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(Integer idCalendario) {
        this.idCalendario = idCalendario;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public StatusCalendario getStatus() {
        return status;
    }

    public void setStatus(StatusCalendario status) {
        this.status = status;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}

// Enum para o Status do Calendário
enum StatusCalendario {
    LIVRE,
    PREFERENCIA,
    FECHADO
}
