package com.hendisantika.spring5reactiveweb.client;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.ExchangeFunctions;

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

}
