package com.example.aop.controller;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    // 실무에서는 이런 엔드포인트가 굉장히 많을 것
    // 각 메소드마다 어떤 값이 들어갔고, 어떤 값이 나오는지 알기 위해서 AOP 로 한 곳에 모아버린다.
    // 특정 중요 부분에 Log 를 남길 때 유용하게 사용한다

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {

        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {

        return user;
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user) {
        System.out.println("put");
        System.out.println("user");

        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {

        // DB Logic -> 1~2 초 정도 걸린다고 가정해서 작성하기
        Thread.sleep(1000 * 2);
    }
}
