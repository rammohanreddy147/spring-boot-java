package com.example.myservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot Microservice!";
    }

    @GetMapping("/greet/{name}")
public String greetByName(@PathVariable String name) {
    return "Hello, " + name + "!";
}

@GetMapping("/info")
public Map<String, String> getInfo() {
    Map<String, String> info = new HashMap<>();
    info.put("version", "1.0.0");
    info.put("description", "My Spring Boot Microservice");
    return info;
}
}