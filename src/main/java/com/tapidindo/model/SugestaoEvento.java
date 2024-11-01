package com.tapidindo.model; 
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sugestao_evento")
public class SugestaoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSugestao;

    @Column(nullable = false)
    private String descricao;

    private String usuarioId; // Pode ser usado para armazenar um nome ou identificador do usuário

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSugestao;

    // Construtores
    public SugestaoEvento() {
        this.dataSugestao = new Date(); // Define a data de sugestão como a data atual
    }

    public SugestaoEvento(String descricao, String usuarioId) {
        this.descricao = descricao;
        this.usuarioId = usuarioId;
        this.dataSugestao = new Date(); // Define a data de sugestão como a data atual
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
