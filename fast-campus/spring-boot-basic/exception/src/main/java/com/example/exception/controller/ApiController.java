package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/user")

// 변수들을 검증할 때 Validated 를 사용하면 된다 (DTO 가 아닌 경우)
@Validated
public class ApiController {

    @GetMapping("")
    // required = false 를 사용하면 꼭 필수가 아니게 된다.
    public User get(
            @Size(min=1)
            @RequestParam String name,

            @NotNull
            @RequestParam(required = false) Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);

        // 예외 발생 로직
        int a = 10 + age;
       return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user) {
        System.out.println(user);

        return user;
    }
}
