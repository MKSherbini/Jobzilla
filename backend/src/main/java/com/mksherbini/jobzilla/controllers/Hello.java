package com.mksherbini.jobzilla.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class Hello {

    @GetMapping
    public Mono<Map<String, String>> HelloWorld() {
        return Mono.just(Map.of("msg", "hello world"));
    }
}
