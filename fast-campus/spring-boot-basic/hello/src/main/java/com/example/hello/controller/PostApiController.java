package com.example.hello.controller;

import com.example.hello.dto.DtoPost;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post-practice")
    public void post(@RequestBody Map<String, Object> requestData) {

        requestData.forEach((key, value) -> {
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });
    }

    // dto 로 Post
    @PostMapping("/dto-post")
    public void dtoPost(@RequestBody DtoPost requestData) {
        System.out.println(requestData);
    }
}


