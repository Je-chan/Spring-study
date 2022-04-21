package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteController {

    @DeleteMapping("/delete-practice/{userId}")
    // delete 는 항상 리소스를 삭제한다는 개념이라 200번대만을 보낸다.
    public void delete(@PathVariable String userId, @RequestParam String account) {

        System.out.println(userId);
        System.out.println(account);
    }



}