package com.example.springcicddemo.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping
    public String sayHello(@RequestParam(defaultValue = "Ayxan") String name) {
        return "Hi, " + name + "!";
    }
}
