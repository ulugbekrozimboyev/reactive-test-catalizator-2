package uz.ulugbek.reactive.catalizator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import uz.ulugbek.reactive.catalizator.handlers.GreetingHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

  @Bean
  public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {

    RequestPredicate helloRoute = GET("/hello").and(accept(MediaType.APPLICATION_JSON));
    return RouterFunctions
            .route(helloRoute, greetingHandler::hello)
            .andRoute(GET("/"), greetingHandler::index);
  }
}