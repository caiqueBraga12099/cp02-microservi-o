package com.github.caiqueBraga12099.registrometeorologico.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "registro_meteorologico")
public class RegistroMeteorologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_id")
    private Long registroId;
    @Column(name = "estacao_nome", nullable = false, length = 100)
    private String estacaoNome;
    @Column(name = "data_registro", nullable = false)
    private LocalDate dataRegistro;
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal temperatura;
    @Column(name = "percentual_umidade", nullable = false, precision = 19, scale = 4)
    private BigDecimal percentualUmidade;
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal precipitacao;
    @Enumerated(EnumType.STRING)
    @Column(name = "condicao_climatica", nullable = false, length = 20)
    private CondicaoClimatica condicaoClimatica;

    public RegistroMeteorologico() {
    }

    public Long getRegistroId() {

        return registroId;
    }

    public void setRegistroId(Long registroId) {

        this.registroId = registroId;
    }

    public String getEstacaoNome() {

        return estacaoNome;
    }

    public void setEstacaoNome(String estacaoNome) {

        this.estacaoNome = estacaoNome;
    }

    public LocalDate getDataRegistro() {

        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {

        this.dataRegistro = dataRegistro;
    }

    public BigDecimal getTemperatura() {

        return temperatura;
    }

    public void setTemperatura(BigDecimal temperatura) {

        this.temperatura = temperatura;
    }

    public BigDecimal getPercentualUmidade() {

        return percentualUmidade;
    }

    public void setPercentualUmidade(BigDecimal percentualUmidade) {

        this.percentualUmidade = percentualUmidade;
    }

    public BigDecimal getPrecipitacao() {

        return precipitacao;
    }

    public void setPrecipitacao(BigDecimal precipitacao) {

        this.precipitacao = precipitacao;
    }

    public CondicaoClimatica getCondicaoClimatica() {

        return condicaoClimatica;
    }

    public void setCondicaoClimatica(CondicaoClimatica condicaoClimatica) {

        this.condicaoClimatica = condicaoClimatica;
    }
}
