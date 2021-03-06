package com.hendisantika.spring5reactiveweb.handler;

import com.hendisantika.spring5reactiveweb.model.Product;
import com.hendisantika.spring5reactiveweb.repository.ProductRepository;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * Created by IntelliJ IDEA.
 * Project : spring5-reactive-web
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/04/20
 * Time: 07.24
 */
public class ProductHandlerImpl implements ProductHandler {

    private final ProductRepository repository;

    public ProductHandlerImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<ServerResponse> getProductFromRepository(ServerRequest request) {
        int personId = Integer.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<Product> personMono = this.repository.getProduct(personId);
        return personMono
                .flatMap(person -> ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(person)))
                .switchIfEmpty(notFound);
    }

    @Override
    public Mono<ServerResponse> saveProductToRepository(ServerRequest request) {
        Mono<Product> product = request.bodyToMono(Product.class);
        return ServerResponse.ok().build(this.repository.saveProduct(product));
    }

    @Override
    public Mono<ServerResponse> getAllProductsFromRepository(ServerRequest request) {
        Flux<Product> products = this.repository.getAllProducts();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(products, Product.class);
    }

}
