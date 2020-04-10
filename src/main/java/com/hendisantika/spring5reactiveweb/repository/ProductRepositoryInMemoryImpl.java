package com.hendisantika.spring5reactiveweb.repository;

import com.hendisantika.spring5reactiveweb.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 * Project : spring5-reactive-web
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/04/20
 * Time: 07.26
 */
public class ProductRepositoryInMemoryImpl implements ProductRepository {

    private final Map<Integer, Product> productMap = new ConcurrentHashMap<>();

    @Override
    public Mono<Product> getProduct(int id) {
        return Mono.justOrEmpty(this.productMap.get(id));
    }

    @Override
    public Flux<Product> getAllProducts() {
        return Flux.fromIterable(this.productMap.values());
    }

}
