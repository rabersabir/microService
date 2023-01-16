package com.atradius.org.search.info.gateway;

import io.cucumber.junit.Cucumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

@RunWith(Cucumber.class)
@SpringBootTest
@AutoConfigureWireMock(port = 0)
@Import(TestApplication.class)
class InformationGatewayServiceApplicationTests {

    // A service that calls out over HTTP
    @Autowired
    private GatewayClient gatewayClient;
    @Autowired
    Environment environment;

    @BeforeEach
    public void setup() {

        ReflectionTestUtils.setField(gatewayClient, "baseUrl", "http://localhost:" + environment.getProperty("wiremock.server.port"));
    }

    @Test
    void contextLoads() {

    }

}
