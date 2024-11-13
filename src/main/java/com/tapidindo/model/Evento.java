package com.tapidindo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    // Data no formato YYYY-MM-DD
    @Column(name = "data_evento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEvento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Localidade localidade;

    @Column(name = "data_criacao", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    // Enum para Localidade
    public enum Localidade {
        Tapiocaria, Particular, Festival
    }

    // Construtores
    public Evento() {}

    public Evento(String titulo, String descricao, Date dataEvento, Localidade localidade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEvento = dataEvento;
        this.localidade = localidade;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
