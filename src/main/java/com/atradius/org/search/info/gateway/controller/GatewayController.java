package com.atradius.org.search.info.gateway.controller;

import com.atradius.org.search.info.gateway.client.GatewayResponse;
import com.atradius.org.search.info.gateway.service.InformationGatewaySearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GatewayController {

    @Resource
    private InformationGatewaySearchService informationGatewaySearchService;

    @GetMapping("/findCompanies")
    public GatewayResponse findCompanies(FindCompanyRequest findCompanyRequest) {


        informationGatewaySearchService.findCompanies(findCompanyRequest);
        return new GatewayResponse();
    }

}
