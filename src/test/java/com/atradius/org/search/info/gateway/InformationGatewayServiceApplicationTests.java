package com.atradius.org.search.info.gateway;

import com.atradius.org.search.info.gateway.client.InformationGatewayClient;
import io.cucumber.junit.Cucumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(Cucumber.class)
@SpringBootTest
@AutoConfigureWireMock(port = 0)
@Import(TestApplication.class)
class InformationGatewayServiceApplicationTests {

    // A service that calls out over HTTP
    @Autowired
    private InformationGatewayClient informationGatewayClient;
    @Autowired
    private Environment environment;

    @BeforeEach
    public void setup() {

        ReflectionTestUtils.setField(informationGatewayClient, "baseUrl", "http://localhost:" + environment.getProperty("wiremock.server.port"));

    }

    @Test
    void contextLoads() {

    }

}
