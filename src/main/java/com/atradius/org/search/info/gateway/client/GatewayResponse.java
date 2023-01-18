package com.atradius.org.search.info.gateway.client;

import com.atradius.org.search.info.gateway.model.CompanySearchResultItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class GatewayResponse {

    private List<CompanySearchResultItem> companySearchResultItems;
}
