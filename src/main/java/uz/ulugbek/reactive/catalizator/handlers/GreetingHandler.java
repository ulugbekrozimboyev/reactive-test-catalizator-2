package uz.ulugbek.reactive.catalizator.handlers;

import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.ulugbek.reactive.catalizator.model.Greeting;

import java.awt.*;
import java.util.Map;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {

        Long start = request.queryParam("start")
                .map(Long::valueOf)
                .orElse(0l);
        Long count = request.queryParam("count")
                .map(Long::valueOf)
                .orElse(3l);

        Flux<Greeting> data = Flux
                .just("Helloo, reactive",
                        "More than one",
                        "Third post",
                        "Forth post",
                        "Fifth post"
                        )
                .skip(start)
                .take(count)
                .map(Greeting::new);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(data, Greeting.class);
    }

    public Mono<ServerResponse> index(ServerRequest request) {
        String userName = request.queryParam("user")
                .orElse("Nobody");
        return ServerResponse
                .ok()
                .render("index", Map.of("user", userName));
    }
}