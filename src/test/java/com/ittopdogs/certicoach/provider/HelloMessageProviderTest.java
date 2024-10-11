package com.ittopdogs.certicoach.provider;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloMessageProviderTest {

    @Test
    @DisplayName("Can get the message")
    void getMessageWithParam() {
        //Given
        var provider = new HelloMessageProvider();

        //When
        String message = provider.getMessage("World!");

        //Then
        assertEquals("Hello World!", message);
    }
}
