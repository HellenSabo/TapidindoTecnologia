package com.tapidindo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sugestao_evento")
public class SugestaoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sugestao", nullable = false)
    private Integer idSugestao;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "usuario_id")
    private String usuarioId;

    @Column(name = "data_sugestao", nullable = false, updatable = false, insertable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSugestao;

    // Construtores
    public SugestaoEvento() {}

    public SugestaoEvento(String descricao, String usuarioId) {
        this.descricao = descricao;
        this.usuarioId = usuarioId;
    }

    // Getters e Setters
    public Integer getIdSugestao() {
        return idSugestao;
    }

    public void setIdSugestao(Integer idSugestao) {
        this.idSugestao = idSugestao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getDataSugestao() {
        return dataSugestao;
    }

    public void setDataSugestao(Date dataSugestao) {
        this.dataSugestao = dataSugestao;
    }
}