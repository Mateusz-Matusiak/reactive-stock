package pl.matusiak.stock.ui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.matusiak.stock.client.StockPrice;
import pl.matusiak.stock.client.WebClientStockClient;

import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

@Component
public class ChartController implements Consumer<StockPrice> {
    private static final Logger log = LoggerFactory.getLogger(ChartController.class);
    @FXML
    public LineChart<String, Double> chart;
    private final WebClientStockClient webClientStockClient;
    private final ObservableList<XYChart.Data<String, Double>> seriesData = FXCollections.observableArrayList();

    public ChartController(WebClientStockClient webClientStockClient) {
        this.webClientStockClient = webClientStockClient;
    }

    @FXML
    public void initialize() {
        ObservableList<XYChart.Series<String, Double>> data = FXCollections.observableArrayList();
        String symbol = "SYMBOL";
        data.add(new XYChart.Series<>(symbol, seriesData));
        chart.setData(data);

        webClientStockClient.pricesFor(symbol).subscribe(this);
    }

    @Override
    public void accept(StockPrice stockPrice) {
        Platform.runLater(
                () -> seriesData.add(new XYChart.Data<>(
                        stockPrice.time().format(DateTimeFormatter.ISO_LOCAL_TIME), stockPrice.price())
                ));
    }
}
