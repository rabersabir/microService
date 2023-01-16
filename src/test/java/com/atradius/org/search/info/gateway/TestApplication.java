package com.atradius.org.search.info.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TestApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
