package com.atradius.org.search.info.gateway.client;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InformationGateWayRequest {
    private String consumer;
    private RequestPayload requestPayload;

}
