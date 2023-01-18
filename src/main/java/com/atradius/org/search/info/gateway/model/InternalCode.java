package com.atradius.org.search.info.gateway.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class InternalCode {

    public String type;
    public String provider;
    public String identifier;
    public Object identifierType;

}
