package com.atradius.org.search.info.gateway.client;


import com.atradius.org.search.info.gateway.model.CompanySearchResultItem;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.*;

@Component
public class InformationGatewayClient {

    private final static String PROVIDERCODE = "";

    @Value("${information.gateway.base.url}")
    private String baseUrl;

    @Value("${information.gateway.api.path}")
    private String apiPath;

    public GatewayResponse queryInformationGateway(InformationGateWayRequest informationGateWayRequest)   {
        WebClient webClient = WebClient.create(baseUrl);
        Mono<CompanySearchResultItem[]> createdEmployee = webClient.post()
                .uri(apiPath)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just("{}"), String.class)
                .retrieve()
                .bodyToMono(CompanySearchResultItem[].class);
        GatewayResponse gatewayResponse = new GatewayResponse();
        gatewayResponse.setCompanySearchResultItems(Arrays.asList(Objects.requireNonNull(createdEmployee.block())));
        return gatewayResponse;
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private String composeUrl() {
        return baseUrl + apiPath;
    }

    private static List<HttpMessageConverter<?>> getJsonMessageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new GsonHttpMessageConverter());
        return converters;
    }
}
