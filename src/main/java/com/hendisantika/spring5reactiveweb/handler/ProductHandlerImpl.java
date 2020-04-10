package com.hendisantika.spring5reactiveweb.handler;

import com.hendisantika.spring5reactiveweb.repository.ProductRepository;

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

}
