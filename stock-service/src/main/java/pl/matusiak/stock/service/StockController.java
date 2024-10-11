package pl.matusiak.stock.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
record StockController(PriceService priceService) {

    @GetMapping(value = "/stocks/{symbol}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<StockPrice> prices(@PathVariable String symbol) {
        return priceService.generatePrices(symbol);
    }
}
