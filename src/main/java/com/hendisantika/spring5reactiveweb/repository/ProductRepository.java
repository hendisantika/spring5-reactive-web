package com.hendisantika.spring5reactiveweb.repository;

import com.hendisantika.spring5reactiveweb.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : spring5-reactive-web
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/04/20
 * Time: 07.26
 */
public interface ProductRepository {
    Mono<Product> getProduct(int id);

    Flux<Product> getAllProducts();

    Mono<Void> saveProduct(Mono<Product> product);
}
