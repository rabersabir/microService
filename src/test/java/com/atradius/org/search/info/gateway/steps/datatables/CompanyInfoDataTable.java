package com.atradius.org.search.info.gateway.steps.datatables;


import lombok.Getter;

@Getter
public class CompanyInfoDataTable {
    private final String id;
    private final String companyName;
    private final String description;

    public CompanyInfoDataTable(String id, String companyName, String description) {
        this.id = id;
        this.companyName = companyName;
        this.description = description;
    }
}
