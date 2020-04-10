package com.hendisantika.spring5reactiveweb;

import com.hendisantika.spring5reactiveweb.handler.ProductHandler;
import com.hendisantika.spring5reactiveweb.handler.ProductHandlerImpl;
import com.hendisantika.spring5reactiveweb.repository.ProductRepository;
import com.hendisantika.spring5reactiveweb.repository.ProductRepositoryInMemoryImpl;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ServletHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * Created by IntelliJ IDEA.
 * Project : spring5-reactive-web
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/04/20
 * Time: 07.16
 */
public class Server {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.startTomcatServer("localhost", 8080);
        System.out.println("Press ENTER to exit.");
        System.in.read();
    }

    public RouterFunction<ServerResponse> routingFunction() {
        ProductRepository repository = new ProductRepositoryInMemoryImpl();
        ProductHandler handler = new ProductHandlerImpl(repository);

        return nest(path("/product"),
                nest(accept(APPLICATION_JSON),
                        route(GET("/{id}"), handler::getProductFromRepository)
                                .andRoute(method(HttpMethod.GET), handler::getAllProductsFromRepository)
                ).andRoute(POST("/")
                        .and(contentType(APPLICATION_JSON)), handler::saveProductToRepository));
    }

    public void startTomcatServer(String host, int port) throws LifecycleException {
        RouterFunction<?> route = routingFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        Tomcat tomcatServer = new Tomcat();
        tomcatServer.setHostname(host);
        tomcatServer.setPort(port);
        Context rootContext = tomcatServer.addContext("", System.getProperty("java.io.tmpdir"));
        ServletHttpHandlerAdapter servlet = new ServletHttpHandlerAdapter(httpHandler);
        Tomcat.addServlet(rootContext, "httpHandlerServlet", servlet);
        rootContext.addServletMappingDecoded("/", "httpHandlerServlet");
        tomcatServer.start();
    }
}
