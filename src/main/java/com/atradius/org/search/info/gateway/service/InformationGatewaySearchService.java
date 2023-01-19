package com.atradius.org.search.info.gateway.service;

import com.atradius.org.search.info.gateway.client.GatewayResponse;
import com.atradius.org.search.info.gateway.client.InformationGateWayRequest;
import com.atradius.org.search.info.gateway.client.InformationGatewayClient;
import com.atradius.org.search.info.gateway.client.RequestPayload;
import com.atradius.org.search.info.gateway.common.DateUtils;
import com.atradius.org.search.info.gateway.controller.FindCompanyRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class InformationGatewaySearchService {


    private final InformationGatewayClient informationGatewayClient;

    public InformationGatewaySearchService(@Autowired InformationGatewayClient informationGatewayClient) {
        this.informationGatewayClient = informationGatewayClient;
    }


    public GatewayResponse findCompanies(FindCompanyRequest findCompanyRequest) {

        InformationGateWayRequest informationGateWayRequest = new InformationGateWayRequest();
        informationGateWayRequest.setConsumer("SHARED_COMPONENT");
        informationGateWayRequest.setRequestPayload(createPayload(findCompanyRequest));
       return informationGatewayClient.queryInformationGateway(informationGateWayRequest);
    }

    private RequestPayload createPayload(FindCompanyRequest findCompanyRequest) {
        RequestPayload requestPayload = new RequestPayload();
        requestPayload.setRequestTimestamp(DateUtils.getDateTimeAsString());
        BeanUtils.copyProperties(findCompanyRequest, requestPayload);
        return requestPayload;
    }
}
