package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/response")
public class ResponseController {
    // Text
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    // JSON
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user;
    }

    @PutMapping("/response-entity")
    // ResponseEntity 에 명확하게 HTTP Status code 를 넣을 수 있게 됐다
    // Header 값도 추가해줄 수 있다.
    // 명확하게 Status 값을 넣어서 보여줄 수 있다.
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
