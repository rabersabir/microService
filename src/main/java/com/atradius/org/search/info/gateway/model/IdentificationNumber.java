package com.atradius.org.search.info.gateway.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class IdentificationNumber {

    public String type;
    public Object provider;
    public String identifier;
    public String identifierType;

}
