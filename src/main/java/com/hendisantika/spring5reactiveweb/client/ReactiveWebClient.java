package com.hendisantika.spring5reactiveweb.client;

import com.hendisantika.spring5reactiveweb.model.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.ExchangeFunctions;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.net.URI;

/**
 * Created by IntelliJ IDEA.
 * Project : spring5-reactive-web
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/04/20
 * Time: 07.45
 */
public class ReactiveWebClient {
    public static final String HOST = "localhost";
    public static final int PORT = 8080;
    private final ExchangeFunction exchange = ExchangeFunctions.create(new ReactorClientHttpConnector());

    public static void main(String[] args) throws Exception {
        ReactiveWebClient client = new ReactiveWebClient();
        client.createProduct();
        client.getAllProduct();
    }

    public void createProduct() {
        URI uri = URI.create(String.format("http://%s:%d/product", HOST, PORT));
        Product shirt = new Product(319, "Spring Guru Jeans", "Spring Framework Guru Denim Jean", "https" +
                "://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt" +
                "-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg", new BigDecimal("35.95"));
        ClientRequest request = ClientRequest.method(HttpMethod.POST, uri)
                .body(BodyInserters.fromObject(shirt)).build();
        Mono<ClientResponse> response = exchange.exchange(request);
        System.out.println(response.block().statusCode());
    }
}
