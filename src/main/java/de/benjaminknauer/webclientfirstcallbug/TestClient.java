package de.benjaminknauer.webclientfirstcallbug;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class TestClient {

    final WebClient webClient;

    public void doCallViaWebClient() {
        webClient.get()
                .uri("http://google.de")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
