package com.atradius.org.search.info.gateway.client;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class CompanyInfo {
    private String name;
    private String value;
    private List<AllowedOperation> allowedOperations;

}
