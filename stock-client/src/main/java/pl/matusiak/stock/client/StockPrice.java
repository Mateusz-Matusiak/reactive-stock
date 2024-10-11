package pl.matusiak.stock.client;

import java.time.LocalDateTime;

public record StockPrice(
        String symbol,
        double price,
        LocalDateTime time
) {
}
