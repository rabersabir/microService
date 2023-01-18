package com.atradius.org.search.info.gateway.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Address {

    public String fullAddress;
    public String streetName;
    public Object place;
    public String postCode;
    public String county;
    public Object text;
    public Object district;
    public Country country;
    public Object telephone;
    public Object fax;
    public Object coordinates;

}
