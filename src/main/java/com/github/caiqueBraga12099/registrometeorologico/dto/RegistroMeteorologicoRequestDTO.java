package com.github.caiqueBraga12099.registrometeorologico.dto;

import com.github.caiqueBraga12099.registrometeorologico.entity.CondicaoClimatica;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RegistroMeteorologicoRequestDTO {

    @NotBlank(message = "Estação é obrigatória")
    @Size(min = 3, max = 100, message = "Estação deve ter entre 3 e 100 caracteres")
    private String estacaoNome;
    @NotNull(message = "Data é obrigatória")
    @PastOrPresent(message = "Data não pode estar no futuro")
    private LocalDate dataRegistro;
    @NotNull(message = "Temperatura é obrigatória")
    private BigDecimal temperatura;
    @NotNull(message = "Umidade é obrigatória")
    @DecimalMin(value = "0", message = "Umidade mínima é 0")
    @DecimalMax(value = "100", message = "Umidade máxima é 100")
    private BigDecimal percentualUmidade;
    @NotNull(message = "Precipitação é obrigatória")
    @DecimalMin(value = "0", message = "Precipitação não pode ser negativa")
    private BigDecimal precipitacao;
    @NotNull(message = "Condição climática é obrigatória")
    private CondicaoClimatica condicaoClimatica;

    public RegistroMeteorologicoRequestDTO() {
    }

    public RegistroMeteorologicoRequestDTO(String estacaoNome, LocalDate dataRegistro, BigDecimal temperatura, BigDecimal percentualUmidade, BigDecimal precipitacao, CondicaoClimatica condicaoClimatica) {

        this.estacaoNome = estacaoNome;
        this.dataRegistro = dataRegistro;
        this.temperatura = temperatura;
        this.percentualUmidade = percentualUmidade;
        this.precipitacao = precipitacao;
        this.condicaoClimatica = condicaoClimatica;
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
