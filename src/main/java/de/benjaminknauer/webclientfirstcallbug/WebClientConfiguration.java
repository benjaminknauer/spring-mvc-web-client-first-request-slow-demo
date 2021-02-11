package de.benjaminknauer.webclientfirstcallbug;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;


@Configuration
public class WebClientConfiguration {

    @Bean
    public WebClient createWebClient(WebClient.Builder webClientBuilder) {
        final HttpClient httpClient = HttpClient.create();
        final ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
        final WebClient webClient = webClientBuilder.clientConnector(connector).build();

        httpClient.warmup().block();

        return webClient;
    }

}
