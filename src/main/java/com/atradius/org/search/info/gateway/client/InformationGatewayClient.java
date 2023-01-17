package com.atradius.org.search.info.gateway.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class InformationGatewayClient {

    @Value("${information.gateway.base.url}")
    private String baseUrl;

    @Value("${information.gateway.api.path}")
    private String apiPath;

    @Autowired
    private RestTemplate template;

    public GatewayResponse queryInformationGateway(InformationGateWayRequest informationGateWayRequest) {

        HttpHeaders headers = getHttpHeaders();

        HttpEntity<InformationGateWayRequest> requestEntity =
                new HttpEntity<>(informationGateWayRequest, headers);
        ResponseEntity<AllowedOperation[]> responseEntity =
                template.exchange(composeUrl(), HttpMethod.POST, requestEntity,
                        AllowedOperation[].class);

        return new GatewayResponse();
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private String composeUrl() {
        return baseUrl + apiPath;
    }
}
