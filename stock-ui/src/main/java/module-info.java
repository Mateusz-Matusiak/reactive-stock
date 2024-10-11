module stock.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.boot;
    requires spring.context;
    requires spring.beans;
    requires spring.core;
    requires spring.boot.autoconfigure;
    requires stock.client;
    requires org.slf4j;

    // Export the package so that JavaFX and other parts of the application can use it
    exports pl.matusiak.stock.ui;

    // Open the package for reflective access by Spring
    opens pl.matusiak.stock.ui to spring.core, spring.beans;
}
