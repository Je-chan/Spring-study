package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get-practice") // RequestMapping 은 모든 Method 에 응답한다
public class GetApiController {

    @GetMapping(path = "/hello") // path 를 사용해서 명확하게 표현하는 방법
    public String getHello() {
        return "get Hello";
    }

    // 아래의 코드는 옛날 방식
    @RequestMapping(path="/hi", method = RequestMethod.GET) // 이렇게 하면 GET 메소드에 국한 하는 것
    public String hi () {
        return "hi";
    }

    // PathValuable
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name) {
        System.out.println("PathVariable : "+ name);

        return name;
    }

    // Query Parameter

}
