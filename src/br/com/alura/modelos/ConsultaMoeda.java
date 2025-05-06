package br.com.alura.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoeda {

    public double converter(String moedaOrigem, String moedaDestino, double valor)
            throws IOException, InterruptedException {

        String endereco = "https://v6.exchangerate-api.com/v6/d28b8724323129e71effdf66/latest/" + moedaOrigem;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        Gson gson = new Gson();
        Moeda moeda = gson.fromJson(json, Moeda.class);

        Double taxa = moeda.getTaxasConversao().get(moedaDestino);

        return valor * taxa;
    }
}
