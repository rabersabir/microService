package com.atradius.org.search.info.gateway.controller;

import com.atradius.org.search.info.gateway.client.SearchCriteria;

import java.util.List;

public class FindCompanyRequest {

    private String correlationId;
    private String countryId;
    private List<SearchCriteria> searchCriteriaList;
}
