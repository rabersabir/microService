package com.atradius.org.search.info.gateway;

import com.atradius.org.search.info.gateway.client.GatewayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Slf4j
public class TestUtils {

    public static GatewayResponse  callAPI() {
        WebClient webClient = WebClient.create("http://localhost:8080");
        Mono<GatewayResponse> createdEmployee = webClient.post()
                .uri("/findCompanies")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just("{}"), String.class)
                .retrieve()
                .bodyToMono(GatewayResponse.class);
        return createdEmployee.block();
    }
}
