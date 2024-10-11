package pl.matusiak.stock.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.IOException;

public record WebClientStockClient(WebClient webClient) {


    private static final Logger log = LoggerFactory.getLogger(WebClientStockClient.class);

    public Flux<StockPrice> pricesFor(final String symbol) {
        return webClient.get().uri("http://localhost:8080/stocks/{symbol}", symbol)
                .retrieve()
                .bodyToFlux(StockPrice.class)
                .retry(3)
                .doOnError(IOException.class, e -> log.warn("", e));
    }
}
