package com.example.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// HTML 페이지 resource 를 찾는 어노테이션
@Controller
public class PageController {

    // 자동으로 Resource 에 있는 html 파일을 찾아가게 된다.
    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }
}
