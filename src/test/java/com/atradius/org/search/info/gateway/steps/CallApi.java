package com.atradius.org.search.info.gateway.steps;

import com.atradius.org.search.info.gateway.TestUtils;
import com.atradius.org.search.info.gateway.client.GatewayResponse;
import com.atradius.org.search.info.gateway.steps.datatables.CompanyInfoDataTable;
import io.cucumber.java.en.Given;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CallApi {
    @Given("I search for for company I expect this result")
    public void iSearchForForCompanyIExpectThisResult(List<CompanyInfoDataTable> companyInfoDataTables) {
        GatewayResponse response = TestUtils.callAPI(GatewayResponse.class);
        assertThat(response.getCompanySearchResultItems().size()).isEqualTo(companyInfoDataTables.size());
    }

}
