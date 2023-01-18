package com.atradius.org.search.info.gateway.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanySearchResultItem {

    public InternalCode internalCode;
    public String name;
    public Object firstSurname;
    public Object secondSurname;
    public Address address;
    public List<EconomicActivity> economicActivities = null;
    public List<IdentificationNumber> identificationNumbers = null;

}


