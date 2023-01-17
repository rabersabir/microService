package com.atradius.org.search.info.gateway.client;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class RequestPayload {

    private String correlationId;
    private String requestTimestamp;
    private String countryId;
    private List<SearchCriteria> searchCriteriaList;

}
