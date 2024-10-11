package com.ittopdogs.certicoach.controller;

import com.ittopdogs.certicoach.provider.HelloMessageProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloMessageProvider messageProvider;

    @Test
    void testHelloEndpoint_ReturnsHelloWorld() throws Exception {
        // Arrange: Stel de verwachte boodschap in op de mock
        when(messageProvider.getMessage(anyString())).thenReturn("Hello World!");

        // Act & Assert: Verzend een GET-verzoek en controleer het resultaat
        mockMvc.perform(get("/hello/maaktNietUit"))
            .andExpect(status().isOk()) // Verwacht een 200 OK status
            .andExpect(content().string("Hello World!")); // Controleer of de inhoud klopt
    }

}
