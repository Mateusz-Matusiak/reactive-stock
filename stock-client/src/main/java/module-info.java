module stock.client {
    requires spring.context;
    requires spring.webflux;
    requires spring.boot.autoconfigure;
    requires org.slf4j;
    requires reactor.core;
    exports pl.matusiak.stock.client;
    opens pl.matusiak.stock.client to spring.core;
}