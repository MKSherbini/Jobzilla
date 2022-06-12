package com.mksherbini.jobzilla.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Hello {

    @GetMapping
    public Map<String, String> HelloWorld() {
        return Map.of("msg", "hello world");
    }
}
