package pl.matusiak.stock.service;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
record RSocketController(PriceService priceService) {
    @MessageMapping("stockPrices")
    Flux<StockPrice> prices(String symbol) {
        return priceService.generatePrices(symbol);
    }
}
