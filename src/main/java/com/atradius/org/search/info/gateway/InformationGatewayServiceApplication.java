package com.atradius.org.search.info.gateway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication()
@OpenAPIDefinition(info = @Info(title = "InformationGatewayService", version = "1.0", description = "A micro service for to retrieve search results from Information Gateway"))
public class InformationGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InformationGatewayServiceApplication.class, args);
    }
}
