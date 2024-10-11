package com.ittopdogs.certicoach.configration;

import com.ittopdogs.certicoach.provider.HelloMessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfiguration {

    @Bean
    public HelloMessageProvider helloMessageProvider() {
        return new HelloMessageProvider();
    }

}
