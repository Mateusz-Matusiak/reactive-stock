package pl.matusiak.stock.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
class PriceService {

    Flux<StockPrice> generatePrices(String symbol) {
        return Flux.interval(Duration.ofSeconds(1))
                .map(nothing -> new StockPrice(symbol, randomPrice(), LocalDateTime.now()));
    }

    private double randomPrice() {
        return ThreadLocalRandom.current().nextDouble(100.);
    }
}
