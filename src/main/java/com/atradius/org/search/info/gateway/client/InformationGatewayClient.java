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

import java.util.*;

@Component
public class InformationGatewayClient {

    private final static String PROVIDERCODE = "";

    @Value("${information.gateway.base.url}")
    private String baseUrl;

    @Value("${information.gateway.api.path}")
    private String apiPath;

    @Autowired
    private RestTemplate template;

    public GatewayResponse queryInformationGateway(InformationGateWayRequest informationGateWayRequest)   {
        template.setMessageConverters(getJsonMessageConverters());

        HttpHeaders headers = getHttpHeaders();
        HttpEntity<InformationGateWayRequest> requestEntity =  new HttpEntity<>(informationGateWayRequest, headers);
        ResponseEntity<CompanySearchResultItem[]> responseEntity =         template.exchange(composeUrl(), HttpMethod.POST, requestEntity,
                        CompanySearchResultItem[].class);
        GatewayResponse gatewayResponse = new GatewayResponse();
        gatewayResponse.setCompanySearchResultItems(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));
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
