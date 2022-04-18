package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 Class 는 REST API 를 처리
@RequestMapping("/api") // ReqquestMapping URI 를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello") // localhost:9090/api/hello
    public String hello (){
        return "Hello Spring Boot";
    }
}
