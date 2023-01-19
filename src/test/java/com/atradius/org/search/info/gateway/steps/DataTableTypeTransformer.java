package com.atradius.org.search.info.gateway.steps;

import com.atradius.org.search.info.gateway.steps.datatables.CompanyInfoDataTable;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableTypeTransformer {

    @DataTableType
    public CompanyInfoDataTable companyInfoDataTableTransformer(Map<String, String> row) {

        return new CompanyInfoDataTable(
                row.get("it"),
                row.get("name"),
                row.get("description")
        );
    }
}
