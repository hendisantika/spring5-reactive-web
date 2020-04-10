package com.hendisantika.spring5reactiveweb.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : spring5-reactive-web
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/04/20
 * Time: 07.23
 */
public interface ProductHandler {
    Mono<ServerResponse> getProductFromRepository(ServerRequest request);

    Mono<ServerResponse> saveProductToRepository(ServerRequest request);

}
