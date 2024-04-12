package br.com.rvwtech.ccmj.api;

import br.com.rvwtech.ccmj.api.model.ResponseCurrenciesPair;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateClient {
    private String baseURL = "https://v6.exchangerate-api.com/v6";
    private String apiKey = "759b393eef2b00e220e7b6e8";
    private String pair = "pair";

    public String baseCurrency;
    public String targetCurrency;
    public double amount;

    private String getFullURL(){
        return this.baseURL + "/" + this.apiKey + "/" + this.pair + "/" +
                this.baseCurrency + "/" + this.targetCurrency + "/" + this.amount;
    }

    public ResponseCurrenciesPair getCurrenciesPair(){
        try{
            var requestURL = getFullURL();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestURL))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();


            return gson.fromJson(json, ResponseCurrenciesPair.class);


        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return null;
    }

}
