package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @GetMapping(path="query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue()+"\n");
        });

        return sb.toString();
    }

    @GetMapping(path="query-param-exact")
    public String queryParamExact(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " "  + email + " " + age;
    }

    // 현업에서 가장 많이 사용하는 방식은 DTO
    // Request Param은 붙지 않는다.
    // 알아서 ? 뒤를 파악하고 변수의 이름과 매칭한다
    @GetMapping(path="query-dto")
    public String queryDto(UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
