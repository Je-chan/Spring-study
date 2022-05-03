package com.example.validation.controller;

import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
public class ApiController {

    // 기존에 작성하는 코드의 방식
//    @PostMapping("/user")
//    public User user (@RequestBody User user){
//        System.out.println(user);
//
//         예전의 경우 Validation 을 하기 위해서라면 if 분기를 계속 해야 한다
//        if(user.getPhoneNumber() == "xxx-xxxx-xxxx") {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
//        }
//        if(user.getAge() >= 90) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
//        }
//        return user;
//    }


    @PostMapping("/user")
    // Valid 로 어노테이션을 써야 Validation 을 사용할 수 있다.
    // 아직 예외처리에 대한 공부는 하지 않았으므로 우회해서 예외처리 하는 방법을 배우자면, BindingResult 가 있다
    // @Valid 의 결과 값을 BindingResult 에 담아둔다.
    public ResponseEntity user (@Valid @RequestBody User user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();

            bindingResult.getAllErrors().forEach(objectError -> {
                // 에러가 난다면 어떤 에러가 났는지를 하나씩 아라보는 것
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                // 어떠한 필드에서 에러가 났는지 확인
                System.out.println("filed" + field.getField());

                // 무슨 에러가 났는지 확인
                System.out.println(message);

                sb.append("field : "+ field.getField());
                sb.append("message : " + message);

            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        System.out.println(user);

        return ResponseEntity.ok(user);
    }
}
