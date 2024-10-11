package com.ittopdogs.certicoach.IT;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @CsvSource({
        "1, Hello",
        "2, Welkom bij CertiCoach",
        "3, Goed bezig!",
        "4, Message not found"
    })
    void messageExists(String id, String expectedContent) throws Exception {
        //When
        mockMvc.perform(get("/message/" + Long.parseLong(id)))
            .andExpect(status().isOk())
            .andExpect(content().string(expectedContent));
    }

}
