package br.com.rvwtech.ccmj.main;

import br.com.rvwtech.ccmj.api.ExchangeRateClient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt;
        var apiClient = new ExchangeRateClient();

        while(true) {
            System.out.println("""
                    ==============================================\

                    Bem vindo ao Conversor de Moeda - Powered by RVW\

                    -----------------------------------------------
                    (1) DÓLAR => PESO ARGENTINO\

                    (2) PESO ARGENTINO => DÓLAR\

                    (3) DÓLAR => REAL BRASILEIRO\

                    (4) REAL BRASILEIRO => DÓLAR\

                    (5) DÓLAR => PESO COLOMBIANO\

                    (6) PESO COLOMBIANO => DÓLAR\

                    (7) SAIR\

                    ==============================================""");

            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    apiClient.baseCurrency = "USD";
                    apiClient.targetCurrency = "ARS";
                    break;
                case 2:
                    apiClient.baseCurrency = "ARS";
                    apiClient.targetCurrency = "USD";
                    break;
                case 3:
                    apiClient.baseCurrency = "USD";
                    apiClient.targetCurrency = "BRL";
                    break;
                case 4:
                    apiClient.baseCurrency = "BRL";
                    apiClient.targetCurrency = "USD";
                    break;
                case 5:
                    apiClient.baseCurrency = "USD";
                    apiClient.targetCurrency = "COP";
                    break;
                case 6:
                    apiClient.baseCurrency = "COP";
                    apiClient.targetCurrency = "USD";
                    break;
                case 7 :
                    break;
                default:
                    System.out.println("Opção inválida! Por favor verifique.");
                    break;
            }

            if(opt == 7){break;}

            System.out.println("Digite o valor que deseja converter: ");
            apiClient.amount = sc.nextDouble();

           var result = apiClient.getCurrenciesPair();

           System.out.println("RESULTADO CONSULTA: " + result.result);

            System.out.println("O valor de " + apiClient.baseCurrency + " " + apiClient.amount +
                    "para " + apiClient.targetCurrency + " " + result.conversion_result);

        }
    }
}
