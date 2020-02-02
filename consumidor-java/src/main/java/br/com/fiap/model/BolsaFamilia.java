package br.com.fiap.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * BolsaFamilia
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BolsaFamilia implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("NIS FAVORECIDO")
    private String nisFavorecido;
    @JsonProperty("NOME FAVORECIDO")
    private String nomeFavorecido;
    @JsonProperty("VALOR PARCELA")
    private double valorParcela;
    @JsonProperty("NOME MUNICIPIO")
    private String nomeMunicipio;
    @JsonProperty("UF")
    private String UF;

    public String getNomeFavorecido() {
        return nomeFavorecido;
    }

    public void setNomeFavorecido(String nomeFavorecido) {
        this.nomeFavorecido = nomeFavorecido;
    }

    public String getNisFavorecido() {
        return nisFavorecido;
    }

    public void setNisFavorecido(String nisFavorecido) {
        this.nisFavorecido = nisFavorecido;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String uF) {
        this.UF = uF;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public double getValorParcela() {
        return valorParcela;
    }
}