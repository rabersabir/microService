package com.atradius.org.search.info.gateway;

import com.atradius.org.search.info.gateway.client.GatewayResponse;
import com.atradius.org.search.info.gateway.controller.FindCompanyRequest;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestUtils {


    public static <T> T callAPI(Class<T> clasz) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(getJsonMessageConverters());
        FindCompanyRequest request = new FindCompanyRequest();
        HttpHeaders headers = getHttpHeaders();

        HttpEntity<FindCompanyRequest> requestEntity = new HttpEntity<>(request, headers);
        ResponseEntity<GatewayResponse> response = restTemplate.postForEntity("http://localhost:8080/findCompanies", requestEntity, GatewayResponse.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        return (T) response.getBody();
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private static List<HttpMessageConverter<?>> getJsonMessageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(new GsonHttpMessageConverter());
        return converters;
    }
}
