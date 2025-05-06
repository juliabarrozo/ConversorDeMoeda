package br.com.alura.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Moeda {
    @SerializedName("base_code")
    private String codigo;

    @SerializedName("conversion_rates")
    private Map<String, Double> taxasConversao;

    public String getCodigo() {
        return codigo;
    }

    public Map<String, Double> getTaxasConversao() {
        return taxasConversao;
    }

    @Override
    public String toString() {
        return "Moeda: " + codigo + "\nTaxas disponíveis: " + taxasConversao.keySet();
    }
}
