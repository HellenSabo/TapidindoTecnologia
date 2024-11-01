package com.tapidindo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "contratacao_evento")
public class ContratacaoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContratacao;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @Column(nullable = false)
    private Date dataContratacao;

    @Column(nullable = false)
    private String nomeContratante;

    @Column(nullable = false)
    private String contato;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReserva statusReserva;

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

    public void setId(Integer id) {
      
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}

// Enum para o Status da Reserva
enum StatusReserva {
    RESERVADA,
    FECHADA
}
