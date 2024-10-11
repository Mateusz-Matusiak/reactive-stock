package pl.matusiak.stock.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class ClientConfiguration {

    @Bean
    @ConditionalOnMissingBean
    WebClient webClient() {
        return WebClient.builder().build();
    }
    @Bean
    WebClientStockClient webClientStockClient(WebClient webClient) {
        return new WebClientStockClient(webClient);
    }
}
