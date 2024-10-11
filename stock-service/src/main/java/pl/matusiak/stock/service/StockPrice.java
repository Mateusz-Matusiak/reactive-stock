package pl.matusiak.stock.service;

import java.time.LocalDateTime;

record StockPrice(
    String symbol,
    double price,
    LocalDateTime time
) {

}
