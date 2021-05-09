package com.krydb.poller;

import com.krydb.model.UrlPO;
import com.krydb.persistance.UrlPersister;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Poller {
    private Poller() {
        // Utility class not called
    }
    private static String doSingleUrlPoll(String url) throws Exception{
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(url + " " + response);
            return response.statusCode() == 200 ? "GOOD" : "BAD";
    }

    public static void pollAndUpdateUrls() throws Exception {
        var urls = UrlPersister.fetchAllUrls();
        for (UrlPO url : urls) {
            String status = doSingleUrlPoll(url.getAddress());
            UrlPersister.updateURLStatusByIdent(url.getIdent(), status);
        }
    }
}
