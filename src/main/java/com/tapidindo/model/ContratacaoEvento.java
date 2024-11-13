package com.tapidindo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contratacao_evento")
public class ContratacaoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contratacao", nullable = false)
    private Integer idContratacao;

    @ManyToOne
    @JoinColumn(name = "evento_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_evento_id"))
    private Evento evento;

    @Column(name = "data_contratacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataContratacao;

    @Column(name = "nome_contratante", nullable = false)
    private String nomeContratante;

    @Column(nullable = false)
    private String contato;

    @Column(name = "status_reserva", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusReserva statusReserva;

    // Enum para StatusReserva
    public enum StatusReserva {
        reservada, fechada
    }

    // Construtores
    public ContratacaoEvento() {}

    public ContratacaoEvento(Evento evento, Date dataContratacao, String nomeContratante, String contato, StatusReserva statusReserva) {
        this.evento = evento;
        this.dataContratacao = dataContratacao;
        this.nomeContratante = nomeContratante;
        this.contato = contato;
        this.statusReserva = statusReserva;
    }

    // Getters e Setters
    public Integer getIdContratacao() {
        return idContratacao;
    }

    public void setIdContratacao(Integer idContratacao) {
        this.idContratacao = idContratacao;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getNomeContratante() {
        return nomeContratante;
    }

    public void setNomeContratante(String nomeContratante) {
        this.nomeContratante = nomeContratante;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public StatusReserva getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(StatusReserva statusReserva) {
        this.statusReserva = statusReserva;
    }
}