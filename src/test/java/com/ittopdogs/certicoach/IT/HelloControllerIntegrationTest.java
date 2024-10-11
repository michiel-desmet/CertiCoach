package com.ittopdogs.certicoach.IT;

import com.ittopdogs.certicoach.provider.HelloMessageProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private HelloMessageProvider messageProvider;

    @Test
    void helloEndpointReturnActualMessage() {
        //Given
        final var name = "Michiel";
        final var expectedMessage = messageProvider.getMessage(name);

        //When
        var result = restTemplate.getForEntity("/hello/Michiel", String.class);

        //Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(expectedMessage, result.getBody());
    }

}
