package com.github.caiqueBraga12099.registrometeorologico.dto;

import com.github.caiqueBraga12099.registrometeorologico.entity.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RegistroMeteorologicoResponseDTO {

    private Long registroId;

    private String estacaoNome;

    private LocalDate dataRegistro;

    private BigDecimal temperatura;

    private BigDecimal percentualUmidade;

    private BigDecimal precipitacao;

    private CondicaoClimatica condicaoClimatica;

    public RegistroMeteorologicoResponseDTO() {
    }

    public RegistroMeteorologicoResponseDTO(Long registroId, String estacaoNome, LocalDate dataRegistro, BigDecimal temperatura, BigDecimal percentualUmidade, BigDecimal precipitacao, CondicaoClimatica condicaoClimatica) {

        this.registroId = registroId;
        this.estacaoNome = estacaoNome;
        this.dataRegistro = dataRegistro;
        this.temperatura = temperatura;
        this.percentualUmidade = percentualUmidade;
        this.precipitacao = precipitacao;
        this.condicaoClimatica = condicaoClimatica;
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

    public static RegistroMeteorologicoResponseDTO fromEntity(RegistroMeteorologico r) {

        return new RegistroMeteorologicoResponseDTO(r.getRegistroId(), r.getEstacaoNome(), r.getDataRegistro(),
            r.getTemperatura(), r.getPercentualUmidade(), r.getPrecipitacao(), r.getCondicaoClimatica());
    }
}
