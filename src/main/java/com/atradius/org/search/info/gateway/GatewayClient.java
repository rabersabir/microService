package com.atradius.org.search.info.gateway;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
@Component
public class GatewayClient {

    @Value("${information.gateway.base.url}")
    private String baseUrl;

    @Value("${information.gateway.api.path}")
    private String apiPath;

    @Autowired
    private RestTemplate template;

    public void queryInformationGateway(RequestBody payload) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<RequestBody> requestEntity =
                new HttpEntity<>(payload, headers);
        ResponseEntity<GatewayResponse> response =
                template.exchange(composeUrl(), HttpMethod.POST, requestEntity,
                        GatewayResponse.class);

    }

    private String composeUrl() {
        return baseUrl + apiPath;
    }
}
