package com.ittopdogs.certicoach.IT;

import com.ittopdogs.certicoach.provider.HelloMessageProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class HelloControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HelloMessageProvider messageProvider;

    @Test
    void helloEndpointReturnActualMessage() throws Exception {
        //Given
        final var name = "Michiel";
        final var expectedMessage = messageProvider.getMessage(name);

        //When
        mockMvc
            .perform(get("/hello/" + name))
            .andExpect(status().isOk())
            .andExpect(content().string(expectedMessage));

    }

}
