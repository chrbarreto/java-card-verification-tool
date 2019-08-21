package br.com.chrbarreto.jpay.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

import br.com.chrbarreto.jpay.model.CardDetails;
import org.springframework.web.bind.annotation.RequestMethod;

public class VerifyCardByNumber {

    private final String URL_PREFIX = "https://lookup.binlist.net/";

    public CardDetails verify(Long cardNumber) throws IOException {

        String json = this.getResponseJson(cardNumber);
        Gson gson = new Gson();
        CardDetails cardDetails = gson.fromJson(json, CardDetails.class);

        return cardDetails;

    }

    private String getResponseJson(Long cardNumber) throws IOException {

        URL url = new URL(this.URL_PREFIX + cardNumber);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod(RequestMethod.GET.name());

        try (InputStreamReader inputStreamReader = new InputStreamReader(con.getInputStream())) {
            try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = bufferedReader.readLine()) != null) {
                    content.append(inputLine);
                }
                return content.toString();
            }
        }
    }
}
