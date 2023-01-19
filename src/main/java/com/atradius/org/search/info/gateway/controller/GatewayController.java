package com.atradius.org.search.info.gateway.controller;

import com.atradius.org.search.info.gateway.client.GatewayResponse;
import com.atradius.org.search.info.gateway.service.InformationGatewaySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GatewayController {

    @Autowired
    private InformationGatewaySearchService informationGatewaySearchService;

    @PostMapping("/findCompanies")
    public GatewayResponse findCompanies(FindCompanyRequest findCompanyRequest) {

       return informationGatewaySearchService.findCompanies(findCompanyRequest);

    }

}
