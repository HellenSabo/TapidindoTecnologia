package com.tapidindo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "calendario_reservas")
public class CalendarioReservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calendario", nullable = false)
    private Integer idCalendario;

    @Column(name = "data_evento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEvento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "evento_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_evento_id"))
    private Evento evento;

    // Enum para Status
    public enum Status {
        livre, preferencia, fechado
    }

    // Construtores
    public CalendarioReservas() {}

    public CalendarioReservas(Date dataEvento, Status status, Evento evento) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}