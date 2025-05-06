package br.com.alura.principal;

import br.com.alura.modelos.ConsultaMoeda;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ConsultaMoeda consultaMoeda = new ConsultaMoeda();

        String menu = """ 
                ***************************************
                Seja bem-vindo ao Conversor de Moeda!
                1) Dólar =>> Peso Argentino
                2) Peso Argentino =>> Dólar
                3) Dólar =>> Real Brasileiro
                4) Real Brasileiro =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Dólar
                7) Sair
                Escolha uma opção válida:
                ***************************************
                """;

        int opcao = 0;

        while (opcao != 7) {
            System.out.println(menu);
            opcao = scanner.nextInt();

            if (opcao == 7) {
                break;
            }

            String origem;
            String destino;

            switch (opcao) {
                case 1 -> { origem = "USD"; destino = "ARS"; }
                case 2 -> { origem = "ARS"; destino = "USD"; }
                case 3 -> { origem = "USD"; destino = "BRL"; }
                case 4 -> { origem = "BRL"; destino = "USD"; }
                case 5 -> { origem = "USD"; destino = "COP"; }
                case 6 -> { origem = "COP"; destino = "USD"; }
                default -> {
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
                }
            }

            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            try {
                double convertido = consultaMoeda.converter(origem, destino, valor);
                System.out.printf("Valor %s [%s] corresponde ao valor final de =>> %s [%s]", valor, origem, convertido, destino);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro na conversão: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
