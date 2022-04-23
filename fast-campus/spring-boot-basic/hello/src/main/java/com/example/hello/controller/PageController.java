package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// HTML 페이지 resource 를 찾는 어노테이션

@Controller
public class PageController {

    // 자동으로 Resource 에 있는 html 파일을 찾아가게 된다.
    // 페이지를 리턴한다.
    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    // Controller 어노테이션일 때는(RestController 아님) 어떻게 JSON 의 형태로 내려줄 수 있는가?
    // 1. ResponseEntity

    // 2. ResponseBody 어노테이션은 객체 자체를 리턴했을 때 Response Body 를 만들어서 내리겠다는 것
    @ResponseBody
    @GetMapping("/user")
    public User user( ){
        // var 는 타입 추론을 해주는 것
        var user = new User();
        user.setName("Je");
        user.setAddress("어딘가");
        user.setPhoneNumber("010의 뭔가이지");
        return user;
    }
}

