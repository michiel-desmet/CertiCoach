package com.ittopdogs.certicoach.controller;

import com.ittopdogs.certicoach.provider.HelloMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelloMessageProvider helloMessageProvider;

    public HelloController(HelloMessageProvider helloMessageProvider) {
        this.helloMessageProvider = helloMessageProvider;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return helloMessageProvider.getMessage(name);
    }

}
